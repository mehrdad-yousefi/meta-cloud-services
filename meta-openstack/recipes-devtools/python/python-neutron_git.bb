DESCRIPTION = "Neutron (virtual network service)"
HOMEPAGE = "https://launchpad.net/neutron"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

PR = "r0"
SRCNAME = "neutron"

SRC_URI = "git://github.com/openstack/${SRCNAME}.git;branch=stable/havana \
           file://ovs_neutron_plugin.ini \
           file://linuxbridge_conf.ini \
           file://neutron-server.init \
           file://neutron-agent.init \
	  "
SRCREV="e79771e9ba2e50b542d2acc127c9d7613e8374bf"
PV="2013.2.2+git${SRCPV}"

S = "${WORKDIR}/git"

inherit setuptools update-rc.d identity hosts

do_install_append() {
    TEMPLATE_CONF_DIR=${S}${sysconfdir}/
    NEUTRON_CONF_DIR=${D}${sysconfdir}/neutron

    sed -e "s:%SERVICE_TENANT_NAME%:${SERVICE_TENANT_NAME}:g" \
        ${TEMPLATE_CONF_DIR}/neutron.conf > ${WORKDIR}/neutron.conf
    sed -e "s:%SERVICE_USER%:${SRCNAME}:g" -i ${WORKDIR}/neutron.conf
    sed -e "s:%SERVICE_PASSWORD%:${SERVICE_PASSWORD}:g" \
        -i ${WORKDIR}/neutron.conf
    sed -e "s:^# core_plugin.*:core_plugin = neutron.plugins.openvswitch.ovs_neutron_plugin.OVSNeutronPluginV2:g" \
        -i ${WORKDIR}/neutron.conf

    echo "rabbit_host = ${CONTROLLER_IP}" >> ${WORKDIR}/neutron.conf

    for file in ovs_neutron_plugin.ini linuxbridge_conf.ini
    do
        sed -e "s:%DB_USER%:${DB_USER}:g" -i ${WORKDIR}/${file}
        sed -e "s:%DB_PASSWORD%:${DB_PASSWORD}:g" -i ${WORKDIR}/${file}
        sed -e "s:%CONTROLLER_IP%:${CONTROLLER_IP}:g" -i ${WORKDIR}/${file}
        sed -e "s:%CONTROLLER_HOST%:${CONTROLLER_HOST}:g" -i ${WORKDIR}/${file}
    done

    install -d ${NEUTRON_CONF_DIR}
    install -d ${NEUTRON_CONF_DIR}/plugins/openvswitch
    install -d ${NEUTRON_CONF_DIR}/plugins/linuxbridge

    install -m 600 ${WORKDIR}/neutron.conf ${NEUTRON_CONF_DIR}/
    install -m 600 ${WORKDIR}/ovs_neutron_plugin.ini ${NEUTRON_CONF_DIR}/plugins/openvswitch/
    install -m 600 ${WORKDIR}/linuxbridge_conf.ini ${NEUTRON_CONF_DIR}/plugins/linuxbridge/
    install -m 600 ${S}/etc/api-paste.ini ${NEUTRON_CONF_DIR}/
    install -m 600 ${S}/etc/policy.json ${NEUTRON_CONF_DIR}/

    install -d ${D}${localstatedir}/log/${SRCNAME}

    PLUGIN=openvswitch
    if ${@base_contains('DISTRO_FEATURES', 'sysvinit', 'true', 'false', d)}; then
        install -d ${D}${sysconfdir}/init.d
        sed "s:@plugin@:/etc/neutron/plugins/$PLUGIN/ovs_neutron_plugin.ini:" \
             < ${WORKDIR}/neutron-server.init >${WORKDIR}/neutron-server.init.sh
        install -m 0755 ${WORKDIR}/neutron-server.init.sh ${D}${sysconfdir}/init.d/neutron-server
        sed "s:@suffix@:$PLUGIN:" < ${WORKDIR}/neutron-agent.init >${WORKDIR}/neutron-$PLUGIN.init.sh
        install -m 0755 ${WORKDIR}/neutron-$PLUGIN.init.sh ${D}${sysconfdir}/init.d/neutron-$PLUGIN-agent
    fi

    cp run_tests.sh ${NEUTRON_CONF_DIR}
}

pkg_postinst_${SRCNAME}-setup () {
    if [ "x$D" != "x" ]; then
        exit 1
    fi

    # This is to make sure postgres is configured and running
    if ! pidof postmaster > /dev/null; then
        /etc/init.d/postgresql-init
        /etc/init.d/postgresql start
        sleep 2
    fi

    sudo -u postgres createdb ovs_neutron
}

pkg_postinst_${SRCNAME}-plugin-openvswitch-setup () {
    if [ "x$D" != "x" ]; then
        exit 1
    fi
   
    /etc/init.d/openvswitch-switch start
    ovs-vsctl --no-wait -- --may-exist add-br br-int
}

ALLOW_EMPTY_${SRCNAME}-setup = "1"
ALLOW_EMPTY_${SRCNAME}-plugin-openvswitch-setup = "1"

PACKAGES += " \
     ${SRCNAME}-tests \
     ${SRCNAME} \
     ${SRCNAME}-doc \
     ${SRCNAME}-server \
     ${SRCNAME}-plugin-openvswitch \
     ${SRCNAME}-plugin-linuxbridge \
     ${SRCNAME}-dhcp-agent \
     ${SRCNAME}-l3-agent \
     ${SRCNAME}-metadata-agent \
     ${SRCNAME}-extra-agents \
     ${SRCNAME}-setup \
     ${SRCNAME}-plugin-openvswitch-setup \
     "

FILES_${PN} = "${libdir}/*"

FILES_${SRCNAME}-tests = "${sysconfdir}/${SRCNAME}/run_tests.sh"

FILES_${SRCNAME} = " \
    ${bindir}/neutron-db-manage \
    ${bindir}/neutron-rootwrap \
    ${bindir}/neutron-debug \
    ${bindir}/neutron-netns-cleanup \
    ${bindir}/neutron-ovs-cleanup \
    ${sysconfdir}/${SRCNAME}/* \
    ${localstatedir}/* \    
    "

FILES_${SRCNAME}-server = "${bindir}/neutron-server \
    ${sysconfdir}/init.d/neutron-server \
    "

FILES_${SRCNAME}-plugin-openvswitch = " \
    ${bindir}/neutron-openvswitch-agent \
    ${sysconfdir}/${SRCNAME}/plugins/openvswitch/ovs_neutron_plugin.ini \
    ${sysconfdir}/init.d/neutron-openvswitch-agent \
    "

FILES_${SRCNAME}-plugin-linuxbridge = " \
    ${bindir}/neutron-linuxbridge-agent \
    ${sysconfdir}/${SRCNAME}/plugins/linuxbridge/linuxbridge_conf.ini \
    ${sysconfdir}/init.d/neutron-linuxbridge-agent \
    "

FILES_${SRCNAME}-dhcp-agent = "${bindir}/neutron-dhcp-agent \
    ${bindir}/neutron-dhcp-agent-dnsmasq-lease-update \
    ${sysconfdir}/${SRCNAME}/dhcp_agent.ini \
    ${sysconfdir}/init.d/dhcp_agent \
    "

FILES_${SRCNAME}-l3-agent = "${bindir}/neutron-l3-agent \
    ${sysconfdir}/${SRCNAME}/l3_agent.ini \
    ${sysconfdir}/init.d/l3_agent \
    "

FILES_${SRCNAME}-metadata-agent = "${bindir}/neutron-metadata-agent \
    ${sysconfdir}/${SRCNAME}/metadata_agent.ini \
    ${sysconfdir}/init.d/metadata_agent \
    "

FILES_${SRCNAME}-extra-agents = "${bindir}/*"

FILES_${SRCNAME}-doc = "${datadir}/*"

RDEPENDS_${PN} += "python-paste \
	python-pastedeploy \
	python-routes \
	python-amqplib \
	python-anyjson \
	python-alembic \
	python-eventlet \
	python-greenlet \
	python-httplib2 \
	python-iso8601 \
	python-kombu \
	python-netaddr \
	python-neutronclient \
	python-sqlalchemy \
	python-webob \
	python-keystoneclient \
	python-oslo.config \
	python-pyudev \
	python-novaclient \
	python-mako \
	python-markupsafe \
	python-pyparsing \
	"

RDEPENDS_${SRCNAME} = "${PN} \
        postgresql postgresql-client python-psycopg2"

RDEPENDS_${SRCNAME}-server = "${SRCNAME}"
RDEPENDS_${SRCNAME}-plugin-openvswitch = "${SRCNAME} ${SRCNAME}-plugin-openvswitch-setup openvswitch-switch "
RDEPENDS_${SRCNAME}-plugin-linuxbridge = "${SRCNAME} bridge-utils"
RDEPENDS_${SRCNAME}-dhcp-agent = "${SRCNAME} dnsmasq"
RDEPENDS_${SRCNAME}-l3-agent = "${SRCNAME} ${SRCNAME}-metadata-agent iputils"

RRECOMMENDS_${SRCNAME}-server = "${SRCNAME}-plugin-openvswitch"

INITSCRIPT_PACKAGES = "${SRCNAME}-server ${SRCNAME}-plugin-openvswitch ${SRCNAME}-plugin-linuxbridge"
INITSCRIPT_NAME_${SRCNAME}-server = "neutron-server"
INITSCRIPT_NAME_${SRCNAME}-plugin-openvswitch = "neutron-openvswitch-agent"
INITSCRIPT_NAME_${SRCNAME}-plugin-linuxbridge = "neutron-linuxbridge-agent"
