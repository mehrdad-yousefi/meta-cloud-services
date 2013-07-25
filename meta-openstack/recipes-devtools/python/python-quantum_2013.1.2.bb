DESCRIPTION = "Quantum (virtual network service)"
HOMEPAGE = "https://launchpad.net/quantum"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

PR = "r0"
SRCNAME = "quantum"

SRC_URI = "https://launchpad.net/${SRCNAME}/grizzly/${PV}/+download/${SRCNAME}-${PV}.tar.gz \
      file://ovs_quantum_plugin.ini \
      file://linuxbridge_conf.ini \
      file://quantum-server.init \
      file://quantum-agent.init \
	  "

SRC_URI[md5sum] = "890ec5be7cede9cef6c8033412b74fe9"
SRC_URI[sha256sum] = "08752d58fc010332c527974ddff0475378f6104e77de40b0a690580f672c7fd2"


S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools update-rc.d identity

do_install_append() {
    TEMPLATE_CONF_DIR=${S}${sysconfdir}/
    QUANTUM_CONF_DIR=${D}${sysconfdir}/quantum

    sed -e "s:%SERVICE_TENANT_NAME%:${SERVICE_TENANT_NAME}:g" \
        ${TEMPLATE_CONF_DIR}/quantum.conf > ${WORKDIR}/quantum.conf
    sed -e "s:%SERVICE_USER%:${SRCNAME}:g" -i ${WORKDIR}/quantum.conf
    sed -e "s:%SERVICE_PASSWORD%:${SERVICE_PASSWORD}:g" \
        -i ${WORKDIR}/quantum.conf
    sed -e "s:^# core_plugin.*:core_plugin = quantum.plugins.openvswitch.ovs_quantum_plugin.OVSQuantumPluginV2:g" \
        -i ${WORKDIR}/quantum.conf

    for file in ovs_quantum_plugin.ini linuxbridge_conf.ini
    do
        sed -e "s:%DB_USER%:${DB_USER}:g" -i ${WORKDIR}/${file}
        sed -e "s:%DB_PASSWORD%:${DB_PASSWORD}:g" -i ${WORKDIR}/${file}
    done

    install -d ${QUANTUM_CONF_DIR}
    install -d ${QUANTUM_CONF_DIR}/plugins/openvswitch
    install -d ${QUANTUM_CONF_DIR}/plugins/linuxbridge

    install -m 600 ${WORKDIR}/quantum.conf ${QUANTUM_CONF_DIR}/
    install -m 600 ${WORKDIR}/ovs_quantum_plugin.ini ${QUANTUM_CONF_DIR}/plugins/openvswitch/
    install -m 600 ${WORKDIR}/linuxbridge_conf.ini ${QUANTUM_CONF_DIR}/plugins/linuxbridge/
    install -m 600 ${S}/etc/api-paste.ini ${QUANTUM_CONF_DIR}/
    install -m 600 ${S}/etc/policy.json ${QUANTUM_CONF_DIR}/

    PLUGIN=openvswitch
    if ${@base_contains('DISTRO_FEATURES', 'sysvinit', 'true', 'false', d)}; then
        install -d ${D}${sysconfdir}/init.d
        sed "s:@plugin@:/etc/quantum/plugins/$PLUGIN/ovs_quantum_plugin.ini:" \
             < ${WORKDIR}/quantum-server.init >${WORKDIR}/quantum-server.init.sh
        install -m 0755 ${WORKDIR}/quantum-server.init.sh ${D}${sysconfdir}/init.d/quantum-server
        sed "s:@suffix@:$PLUGIN:" < ${WORKDIR}/quantum-agent.init >${WORKDIR}/quantum-$PLUGIN.init.sh
        install -m 0755 ${WORKDIR}/quantum-$PLUGIN.init.sh ${D}${sysconfdir}/init.d/quantum-$PLUGIN-agent
    fi
}

pkg_postinst_${SRCNAME} () {
    if [ "x$D" != "x" ]; then
        exit 1
    fi

    # This is to make sure postgres is configured and running
    if ! pidof postmaster > /dev/null; then
       sudo -u postgres initdb -D /etc/postgresql/
       /etc/init.d/postgresql start
       sleep 0.2
       sudo -u postgres psql -c "CREATE ROLE ${DB_USER} WITH SUPERUSER LOGIN PASSWORD '${DB_PASSWORD}'"
    fi

    sudo -u postgres createdb ovs_quantum
}

pkg_postinst_${SRCNAME}-plugin-openvswitch () {
    if [ "x$D" != "x" ]; then
        exit 1
    fi

    /etc/init.d/openvswitch-switch start
    ovs-vsctl --no-wait -- --may-exist add-br br-int
}

PACKAGES += " \
     ${SRCNAME} \
     ${SRCNAME}-doc \
     ${SRCNAME}-server \
     ${SRCNAME}-plugin-openvswitch \
     ${SRCNAME}-plugin-linuxbridge \
     ${SRCNAME}-dhcp-agent \
     ${SRCNAME}-l3-agent \
     ${SRCNAME}-metadata-agent \
     ${SRCNAME}-extra-agents \
     "

FILES_${PN} = "${libdir}/*"

FILES_${SRCNAME} = " \
    ${bindir}/quantum-db-manage \
    ${bindir}/quantum-rootwrap \
    ${bindir}/quantum-debug \
    ${bindir}/quantum-netns-cleanup \
    ${bindir}/quantum-ovs-cleanup \
    ${sysconfdir}/${SRCNAME}/* "

FILES_${SRCNAME}-server = "${bindir}/quantum-server \
    ${sysconfdir}/init.d/quantum-server \
    "

FILES_${SRCNAME}-plugin-openvswitch = " \
    ${bindir}/quantum-openvswitch-agent \
    ${sysconfdir}/${SRCNAME}/plugins/openvswitch/ovs_quantum_plugin.ini \
    ${sysconfdir}/init.d/quantum-openvswitch-agent \
    "

FILES_${SRCNAME}-plugin-linuxbridge = " \
    ${bindir}/quantum-linuxbridge-agent \
    ${sysconfdir}/${SRCNAME}/plugins/linuxbridge/linuxbridge_conf.ini \
    ${sysconfdir}/init.d/quantum-linuxbridge-agent \
    "

FILES_${SRCNAME}-dhcp-agent = "${bindir}/quantum-dhcp-agent \
    ${sysconfdir}/${SRCNAME}/dhcp_agent.ini \
    ${sysconfdir}/init.d/dhcp_agent \
    "

FILES_${SRCNAME}-l3-agent = "${bindir}/quantum-l3-agent \
    ${sysconfdir}/${SRCNAME}/l3_agent.ini \
    ${sysconfdir}/init.d/l3_agent \
    "

FILES_${SRCNAME}-metadata-agent = "${bindir}/quantum-metadata-agent \
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
	python-quantumclient \
	python-sqlalchemy \
	python-webob \
	python-keystoneclient \
	python-oslo.config \
	python-pyudev \
	python-novaclient \
    python-mako \
    python-markupsafe \
	"

RDEPENDS_${SRCNAME} = "${PN} \
        postgresql postgresql-client python-psycopg2"

RDEPENDS_${SRCNAME}-server = "${SRCNAME}"
RDEPENDS_${SRCNAME}-plugin-openvswitch = "${SRCNAME} openvswitch-switch "
RDEPENDS_${SRCNAME}-plugin-linuxbridge = "${SRCNAME} bridge-utils"
RDEPENDS_${SRCNAME}-dhcp-agent = "${SRCNAME} dnsmasq"
RDEPENDS_${SRCNAME}-l3-agent = "${SRCNAME} ${SRCNAME}-metadata-agent iputils"

RRECOMMENDS_${SRCNAME}-server = "${SRCNAME}-plugin-openvswitch"

INITSCRIPT_PACKAGES = "${SRCNAME}-server ${SRCNAME}-plugin-openvswitch ${SRCNAME}-plugin-linuxbridge"
INITSCRIPT_NAME_${SRCNAME}-server = "quantum-server"
INITSCRIPT_NAME_${SRCNAME}-plugin-openvswitch = "quantum-openvswitch-agent"
INITSCRIPT_NAME_${SRCNAME}-plugin-linuxbridge = "quantum-linuxbridge-agent"
