DESCRIPTION = "Neutron (virtual network service)"
HOMEPAGE = "https://launchpad.net/neutron"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

SRCNAME = "neutron"

SRC_URI = "git://github.com/openstack/${SRCNAME}.git;branch=stable/zed;protocol=https \
           file://neutron-server.service \
           file://neutron.conf \
           file://l3_agent.ini \
           file://dhcp_agent.ini \
           file://metadata_agent.ini \
           file://metering_agent.ini \
           file://ml2/linuxbridge_agent.ini.sample \
           file://ml2/macvtap_agent.ini.sample \
           file://ml2/ml2_conf.ini.sample \
           file://ml2/openvswitch_agent.ini.sample \
           file://ml2/sriov_agent.ini.sample \
           file://neutron-dhcp-agent.service \
           file://neutron-linuxbridge-agent.service \
           file://neutron-metadata-agent.service \
           file://neutron-init.service \
           file://neutron-init \
           file://neutron_sudoers \
           file://neutron-dhcp-agent-netns-cleanup.cron \
	  "

SRCREV = "8eefeb36b45770259ece9e7a60b48c427a1cf27a"
PV = "21.0.0+git${SRCPV}"

S = "${WORKDIR}/git"

inherit setuptools3 systemd useradd identity hosts default_configs monitor

USER = "neutron"
GROUP = "neutron"

USERADD_PACKAGES = "${PN}"
GROUPADD_PARAM:${PN} = "--system ${GROUP}"
USERADD_PARAM:${PN} = "--system -m -d ${localstatedir}/lib/neutron -s /bin/false -g ${GROUP} ${USER}"

SERVICECREATE_PACKAGES = "${SRCNAME}-setup"
KEYSTONE_HOST="${CONTROLLER_IP}"

# USERCREATE_PARAM and SERVICECREATE_PARAM contain the list of parameters to be set.
# If the flag for a parameter in the list is not set here, the default value will be given to that parameter.
# Parameters not in the list will be set to empty.

USERCREATE_PARAM_${SRCNAME}-setup = "name pass tenant role email"
SERVICECREATE_PARAM_${SRCNAME}-setup = "name type description region publicurl adminurl internalurl"
python () {
    flags = {'type':'network',\
             'description':'OpenStack Networking service',\
             'publicurl':"'http://${KEYSTONE_HOST}:9696/'",\
             'adminurl':"'http://${KEYSTONE_HOST}:9696/'",\
             'internalurl':"'http://${KEYSTONE_HOST}:9696/'"}

    d.setVarFlags("SERVICECREATE_PARAM_%s-setup" % d.getVar('SRCNAME',True), flags)
}

do_install:append() {
    TEMPLATE_CONF_DIR=${S}${sysconfdir}/
    NEUTRON_CONF_DIR=${D}${sysconfdir}/neutron

    install -d -g ${GROUP} -m 750 ${NEUTRON_CONF_DIR}
    install -d -g ${GROUP} -m 750 ${NEUTRON_CONF_DIR}/plugins
    install -d -g ${GROUP} -m 750 ${NEUTRON_CONF_DIR}/plugins/ml2

    # Available directly from source
    install -m 640 -g ${GROUP} ${S}/etc/api-paste.ini ${NEUTRON_CONF_DIR}/

    # Generated using ./tools/generate_config_file_samples.sh
    install -m 640 -g ${GROUP} ${WORKDIR}/neutron.conf ${NEUTRON_CONF_DIR}/
    install -m 640 -g ${GROUP} ${WORKDIR}/dhcp_agent.ini ${NEUTRON_CONF_DIR}/
    install -m 640 -g ${GROUP} ${WORKDIR}/metadata_agent.ini ${NEUTRON_CONF_DIR}/
    install -m 640 -g ${GROUP} ${WORKDIR}/metering_agent.ini ${NEUTRON_CONF_DIR}/

    # install ml2 plugin ini files (also generated using ./tools/generate_config_file_samples.sh)
    for j in linuxbridge_agent macvtap_agent ml2_conf openvswitch_agent sriov_agent
    do
        install -m 640 -g ${GROUP} ${WORKDIR}/ml2/$j.ini.sample ${NEUTRON_CONF_DIR}/plugins/ml2/$j.ini
    done

    # Neutron.conf config changes (replace with .ini file editing)
    CONF_FILE=${NEUTRON_CONF_DIR}/neutron.conf
    sed -e "/#core_plugin =/acore_plugin = ml2" -i ${CONF_FILE}
    sed -e "/#service_plugins =/aservice_plugins =" -i ${CONF_FILE}
    sed -e "/#transport_url =/atransport_url = rabbit://openstack:${ADMIN_PASSWORD}@${CONTROLLER_IP}" -i ${CONF_FILE}
    sed -e "/#auth_strategy =/aauth_strategy = keystone" -i ${CONF_FILE}
    sed -e "/#root_helper =/aroot_helper = sudo ${bindir}/neutron-rootwrap ${sysconfdir}/neutron/rootwrap.conf" -i ${CONF_FILE}
    
    str="auth_uri = http://${CONTROLLER_IP}:5000"
    str="$str\nauth_url = http://${CONTROLLER_IP}:35357"
    str="$str\nmemcached_servers = ${CONTROLLER_IP}:11211"
    str="$str\nauth_type = password"
    str="$str\nproject_domain_name = Default"
    str="$str\nuser_domain_name = Default"
    str="$str\nproject_name = service"
    str="$str\nusername = ${USER}"
    str="$str\npassword = ${ADMIN_PASSWORD}"
    sed -e "/^\[keystone_authtoken\].*/a$str" -i ${CONF_FILE}
    
    sed -e "/^#connection = .*/aconnection = postgresql+psycopg2://${DB_USER}:${DB_PASSWORD}@localhost/neutron" \
            -i ${CONF_FILE}


    # ml2_conf.ini changes (replace with .ini file editing)
    CONF_FILE=${NEUTRON_CONF_DIR}/plugins/ml2/ml2_conf.ini
    sed -e "/#type_drivers =/atype_drivers = flat,vlan" -i ${CONF_FILE} 
    sed -e "/#tenant_network_types =/atenant_network_types =" -i ${CONF_FILE}
    sed -e "/#mechanism_drivers =/amechanism_drivers = linuxbridge" -i ${CONF_FILE}
    sed -e "/#extension_drivers =/aextension_drivers = port_security" -i ${CONF_FILE}
    sed -e "/#flat_networks =/aflat_networks = provider" -i ${CONF_FILE}
    sed -e "/#enable_ipset =/aenable_ipset = true" -i ${CONF_FILE}

    # dhcp-agent
    CONF_FILE=${NEUTRON_CONF_DIR}/dhcp_agent.ini
    sed -e "/#interface_driver =/ainterface_driver = linuxbridge" -i ${CONF_FILE}
    sed -e "/#dhcp_driver =/adhcp_driver = neutron.agent.linux.dhcp.Dnsmasq" -i ${CONF_FILE}
    sed -e "/#enable_isolated_metadata =/aenable_isolated_metadata = true" -i ${CONF_FILE}
    
    install -d ${D}${sysconfdir}/cron.d
    CRON_FILE=${D}${sysconfdir}/cron.d/neutron-dhcp-agent-netns-cleanup
    install -m 644 ${WORKDIR}/neutron-dhcp-agent-netns-cleanup.cron ${CRON_FILE}
    sed "s:@bindir@:${bindir}:g;s:@confdir@:${sysconfdir}:g" -i ${CRON_FILE}

    # linuxbridge
    CONF_FILE=${NEUTRON_CONF_DIR}/plugins/ml2/linuxbridge_agent.ini
    sed -e "/#physical_interface_mappings =/aphysical_interface_mappings = provider:eth0" -i ${CONF_FILE}
    sed -e "/#enable_vxlan/aenable_vxlan = false" -i ${CONF_FILE}
    sed -e "/#enable_security_group =/aenable_security_group = true" -i ${CONF_FILE}
    sed -e "/#firewall_driver =/afirewall_driver = neutron.agent.linux.iptables_firewall.IptablesFirewallDriver" -i ${CONF_FILE}

    #PLUGIN=openvswitch
    #ARGS="--config-file=${sysconfdir}/${SRCNAME}/neutron.conf --config-file=${sysconfdir}/${SRCNAME}/plugins/ml2/ml2_conf.ini"
    #if ${@bb.utils.contains('DISTRO_FEATURES', 'sysvinit', 'true', 'false', d)}; then
    #    install -d ${D}${sysconfdir}/init.d
    #    sed "s:@plugin@:/etc/neutron/plugins/ml2/ml2_conf.ini:" \
    #         < ${WORKDIR}/neutron-server.init >${WORKDIR}/neutron-server.init.sh
    #    install -m 0755 ${WORKDIR}/neutron-server.init.sh ${D}${sysconfdir}/init.d/neutron-server
    #    sed "s:@suffix@:$PLUGIN:;s:@args@:$ARGS:" < ${WORKDIR}/neutron-agent.init >${WORKDIR}/neutron-$PLUGIN.init.sh
    #    install -m 0755 ${WORKDIR}/neutron-$PLUGIN.init.sh ${D}${sysconfdir}/init.d/neutron-$PLUGIN-agent
    #fi
    #
    
    #AGENT=l3
    #ARGS="--config-file=${sysconfdir}/${SRCNAME}/neutron.conf --config-file=${sysconfdir}/${SRCNAME}/l3_agent.ini"
    #if ${@bb.utils.contains('DISTRO_FEATURES', 'sysvinit', 'true', 'false', d)}; then
    #    sed "s:@suffix@:$AGENT:;s:@args@:$ARGS:" < ${WORKDIR}/neutron-agent.init >${WORKDIR}/neutron-$AGENT.init.sh
    #    install -m 0755 ${WORKDIR}/neutron-$AGENT.init.sh ${D}${sysconfdir}/init.d/neutron-$AGENT-agent
    #    install -m 600 ${WORKDIR}/${AGENT}_agent.ini ${NEUTRON_CONF_DIR}/
    #fi
    #
    #AGENT=metadata
    #ARGS="--config-file=${sysconfdir}/${SRCNAME}/neutron.conf --config-file=${sysconfdir}/${SRCNAME}/metadata_agent.ini"
    #if ${@bb.utils.contains('DISTRO_FEATURES', 'sysvinit', 'true', 'false', d)}; then
    #    sed "s:@suffix@:$AGENT:;s:@args@:$ARGS:" < ${WORKDIR}/neutron-agent.init >${WORKDIR}/neutron-$AGENT.init.sh
    #    install -m 0755 ${WORKDIR}/neutron-$AGENT.init.sh ${D}${sysconfdir}/init.d/neutron-$AGENT-agent
    #    install -m 600 ${WORKDIR}/${AGENT}_agent.ini ${NEUTRON_CONF_DIR}/
    #fi
    #
    #for file in plugins/ml2/ml2_conf.ini neutron.conf metadata_agent.ini; do
    #    sed -e "s:%SERVICE_TENANT_NAME%:${SERVICE_TENANT_NAME}:g" -i ${NEUTRON_CONF_DIR}/$file
    #    sed -e "s:%SERVICE_USER%:${SRCNAME}:g" -i ${NEUTRON_CONF_DIR}/$file
    #    sed -e "s:%SERVICE_PASSWORD%:${SERVICE_PASSWORD}:g" -i ${NEUTRON_CONF_DIR}/$file
    #    sed -e "s:%METADATA_SHARED_SECRET%:${METADATA_SHARED_SECRET}:g" -i ${NEUTRON_CONF_DIR}/$file
    #    sed -e "s:%DB_USER%:${DB_USER}:g" -i ${NEUTRON_CONF_DIR}/$file
    #    sed -e "s:%DB_PASSWORD%:${DB_PASSWORD}:g" -i ${NEUTRON_CONF_DIR}/$file
    #    sed -e "s:%CONTROLLER_IP%:${CONTROLLER_IP}:g" -i ${NEUTRON_CONF_DIR}/$file
    #    sed -e "s:%CONTROLLER_HOST%:${CONTROLLER_HOST}:g" -i ${NEUTRON_CONF_DIR}/$file
    #done
    #
    #sed -e "s:^auth_host.*:#auth_host:g" -i ${NEUTRON_CONF_DIR}/neutron.conf
    #sed -e "s:^auth_port.*:#auth_port:g" -i ${NEUTRON_CONF_DIR}/neutron.conf
    #sed -e "s:^auth_protocol.*:#auth_protocol:g" -i ${NEUTRON_CONF_DIR}/neutron.conf
    #sed -i '/\[keystone_authtoken\]/aidentity_uri=http://127.0.0.1:8081/keystone/admin/' ${NEUTRON_CONF_DIR}/neutron.conf
    #
    #cp run_tests.sh ${NEUTRON_CONF_DIR}

    # install systemd service files
    install -d ${D}${systemd_system_unitdir}/
    for j in neutron-server neutron-init neutron-dhcp-agent neutron-linuxbridge-agent neutron-metadata-agent
    do
        SERVICE_FILE=${D}${systemd_system_unitdir}/$j.service
        install -m 644 ${WORKDIR}/$j.service ${SERVICE_FILE}
	sed -e "s#%LOCALSTATEDIR%#${localstatedir}#g" -i ${SERVICE_FILE}
	sed -e "s#%SYSCONFDIR%#${sysconfdir}#g" -i ${SERVICE_FILE}
    done

    # Setup the neutron initialization script
    INIT_FILE=${NEUTRON_CONF_DIR}/neutron-init
    install -g ${USER} -m 750 ${WORKDIR}/neutron-init ${INIT_FILE}
    sed -e "s:%DB_USER%:${DB_USER}:g" -i ${INIT_FILE}
    sed -e "s:%NEUTRON_USER%:${USER}:g" -i ${INIT_FILE}
    sed -e "s:%NEUTRON_GROUP%:${GROUP}:g" -i ${INIT_FILE}
    sed -e "s:%CONTROLLER_IP%:${CONTROLLER_IP}:g" -i ${INIT_FILE}
    sed -e "s:%ADMIN_USER%:${ADMIN_USER}:g" -i ${INIT_FILE}
    sed -e "s:%ADMIN_PASSWORD%:${ADMIN_PASSWORD}:g" -i ${INIT_FILE}
    sed -e "s:%ADMIN_ROLE%:${ADMIN_ROLE}:g" -i ${INIT_FILE}
    sed -e "s:%SYSCONFDIR%:${sysconfdir}:g" -i ${INIT_FILE}
    sed -e "s:%ROOT_HOME%:${ROOT_HOME}:g" -i ${INIT_FILE}

    # setup sudo
    SUDOERS_FILE=${D}${sysconfdir}/sudoers.d/neutron_sudoers
    install -m 750 -d ${D}${sysconfdir}/sudoers.d
    install ${WORKDIR}/neutron_sudoers ${SUDOERS_FILE}
    sed -e "s:%USER%:${USER}:g" -i ${SUDOERS_FILE}

    install -m 600 ${S}/etc/rootwrap.conf ${NEUTRON_CONF_DIR}/
    install -m 750 -d ${NEUTRON_CONF_DIR}/rootwrap.d
    install -m 600 ${S}/etc/neutron/rootwrap.d/* ${NEUTRON_CONF_DIR}/rootwrap.d/
}

pkg_postinst:${SRCNAME}-setup () {
    if [ -z "$D" ]; then
	# This is to make sure postgres is configured and running
	if ! pidof postmaster > /dev/null; then
	    /etc/init.d/postgresql-init
	    /etc/init.d/postgresql start
	    sleep 2
	fi

	sudo -u postgres createdb neutron
	sudo neutron-db-manage --config-file /etc/neutron/neutron.conf  \
			       --config-file /etc/neutron/plugins/ml2/ml2_conf.ini upgrade head
    fi
}

pkg_postinst:${SRCNAME}-plugin-openvswitch-setup () {
    if [ -z "$D" ]; then
	/etc/init.d/openvswitch-switch start
	ovs-vsctl --no-wait -- --may-exist add-br br-int
    fi
}

ALLOW_EMPTY:${SRCNAME}-setup = "1"
ALLOW_EMPTY:${SRCNAME}-plugin-openvswitch-setup = "1"

PACKAGES += " \
     ${SRCNAME}-tests \
     ${SRCNAME} \
     ${SRCNAME}-doc \
     ${SRCNAME}-server \
     ${SRCNAME}-plugin-openvswitch \
     ${SRCNAME}-plugin-ml2 \
     ${SRCNAME}-ml2 \
     ${SRCNAME}-dhcp-agent \
     ${SRCNAME}-linuxbridge-agent \
     ${SRCNAME}-l3-agent \
     ${SRCNAME}-metadata-agent \
     ${SRCNAME}-metering-agent \
     ${SRCNAME}-extra-agents \
     ${SRCNAME}-setup \
     ${SRCNAME}-plugin-openvswitch-setup \
     "

FILES:${PN} = "${libdir}/* \
		/usr/etc/neutron/** \
    "

FILES:${SRCNAME}-tests = "${sysconfdir}/${SRCNAME}/run_tests.sh"
RDEPENDS:${SRCNAME}-tests += " bash"


FILES:${SRCNAME} = " \
    ${bindir}/neutron-db-manage \
    ${bindir}/neutron-rootwrap \
    ${bindir}/neutron-debug \
    ${bindir}/neutron-netns-cleanup \
    ${bindir}/neutron-ovs-cleanup \
    ${sysconfdir}/${SRCNAME}/policy.json \
    ${sysconfdir}/${SRCNAME}/neutron.conf \
    ${sysconfdir}/${SRCNAME}/api-paste.ini \
    ${sysconfdir}/sudoers.d/neutron_sudoers \
    ${sysconfdir}/${SRCNAME}/rootwrap.d \
    ${sysconfdir}/${SRCNAME}/rootwrap.conf \
    ${localstatedir}/* \    
    "

FILES:${SRCNAME}-server = " \
    ${bindir}/neutron-server \
    ${sysconfdir}/neutron/plugin.ini \
    "

FILES:${SRCNAME}-plugin-ml2 = " \
    ${sysconfdir}/${SRCNAME}/plugins/ml2/* \
    "

FILES:${SRCNAME}-plugin-openvswitch = " \
    ${bindir}/neutron-openvswitch-agent \
    ${sysconfdir}/init.d/neutron-openvswitch-agent \
    "

FILES:${SRCNAME}-dhcp-agent = " \
    ${bindir}/neutron-dhcp-agent \
    ${bindir}/neutron-dhcp-agent-dnsmasq-lease-update \
    ${sysconfdir}/${SRCNAME}/dhcp_agent.ini \
    ${sysconfdir}/cron.d/neutron-dhcp-agent-netns-cleanup \
    "

FILES:${SRCNAME}-linuxbridge-agent = " \
    ${bindir}/neutron-linuxbridge-agent \
    ${sysconfdir}/${SRCNAME}/plugins/ml2/linuxbridge_agent.ini \
    "

FILES:${SRCNAME}-l3-agent = " \
    ${bindir}/neutron-l3-agent \
    ${sysconfdir}/${SRCNAME}/l3_agent.ini \
    "

FILES:${SRCNAME}-metadata-agent = " \
    ${bindir}/neutron-metadata-agent \
    ${bindir}/neutron-ns-metadata-proxy \
    ${sysconfdir}/${SRCNAME}/metadata_agent.ini \
    "

FILES:${SRCNAME}-metering-agent = " \
    ${bindir}/neutron-metering-agent \
    ${sysconfdir}/${SRCNAME}/metering_agent.ini \
    "

FILES:${SRCNAME}-extra-agents = "${bindir}/*"

FILES:${SRCNAME}-doc = "${datadir}/*"

FILES:${SRCNAME}-setup = " \
    ${sysconfdir}/neutron/neutron-init \
    "

DEPENDS += " \
        python3-pip \
        python3-pbr \
        "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python3-pbr-native \
	"

RDEPENDS:${PN} += " \
        python3-pbr \
        python3-paste \
        python3-pastedeploy \
        python3-routes \
        python3-debtcollector \
        python3-eventlet \
        python3-pecan \
        python3-httplib2 \
        python3-jinja2 \
        python3-keystonemiddleware \
        python3-netaddr \
        python3-netifaces \
        python-neutron-lib \
        python-neutronclient \
        python3-tenacity \
        python-ryu \
        python3-sqlalchemy \
        python3-webob \
        python3-keystoneauth1 \
        python3-alembic \
        python3-six \
        python3-stevedore \
        python3-oslo.cache \
        python3-oslo.concurrency \
        python3-oslo.config \
        python3-oslo.context \
        python3-oslo.db \
        python3-oslo.i18n \
        python3-oslo.log \
        python3-oslo.messaging \
        python3-oslo.middleware \
        python3-oslo.policy \
        python3-oslo.privsep \
        python3-oslo.reports \
        python3-oslo.rootwrap \
        python3-oslo.serialization \
        python3-oslo.service \
        python3-oslo.utils \
        python3-oslo.versionedobjects \
        python3-osprofiler \
        python3-ovs \
        python3-ovsdbapp \
        python3-psutil \
        python3-pyroute2 \
        python3-weakrefmethod \
        python-novaclient \
        python3-designateclient \
        python3-os-xenapi \
        "

RDEPENDS:${SRCNAME} = "${PN} \
        postgresql postgresql-client python-psycopg2"

RDEPENDS:${SRCNAME}-server = "${SRCNAME} ${SRCNAME}-plugin-ml2 ${SRCNAME}-dhcp-agent ${SRCNAME}-linuxbridge-agent ${SRCNAME}-metadata-agent"
RDEPENDS:${SRCNAME}-plugin-openvswitch = "${SRCNAME} ${SRCNAME}-plugin-ml2 ${SRCNAME}-plugin-openvswitch-setup openvswitch-switch iproute2 bridge-utils"
RDEPENDS:${SRCNAME}-plugin-openvswitch-setup = "openvswitch-switch "
RDEPENDS:${SRCNAME}-dhcp-agent = "${SRCNAME} dnsmasq kea"
RDEPENDS:${SRCNAME}-linuxbridge-agent = "${SRCNAME}"
RDEPENDS:${SRCNAME}-l3-agent = "${SRCNAME} ${SRCNAME}-metadata-agent iputils"
RDEPENDS:${SRCNAME}-metadata-agent = "${SRCNAME}"
RDEPENDS:${SRCNAME}-plugin-ml2 = "${SRCNAME}"
RDEPENDS:${SRCNAME}-setup = "postgresql sudo bash"
RDEPENDS:${SRCNAME}-extra-agents = "bash"

RRECOMMENDS:${SRCNAME}-server = "${SRCNAME}-plugin-openvswitch"

#INITSCRIPT_PACKAGES = "${SRCNAME}-plugin-openvswitch ${SRCNAME}-l3-agent"
#INITSCRIPT_NAME_${SRCNAME}-plugin-openvswitch = "neutron-openvswitch-agent"
#INITSCRIPT_PARAMS_${SRCNAME}-plugin-openvswitch = "${OS_DEFAULT_INITSCRIPT_PARAMS}"
#INITSCRIPT_NAME_${SRCNAME}-l3-agent = "neutron-l3-agent"
#INITSCRIPT_PARAMS_${SRCNAME}-l3-agent = "${OS_DEFAULT_INITSCRIPT_PARAMS}"

SYSTEMD_PACKAGES = " \
    ${SRCNAME}-server \
    ${SRCNAME}-setup \
    ${SRCNAME}-dhcp-agent \
    ${SRCNAME}-linuxbridge-agent \
    ${SRCNAME}-metadata-agent \
    "
SYSTEMD_SERVICE:${SRCNAME}-server = "neutron-server.service"
SYSTEMD_SERVICE:${SRCNAME}-dhcp-agent = "neutron-dhcp-agent.service"
SYSTEMD_SERVICE:${SRCNAME}-linuxbridge-agent = "neutron-linuxbridge-agent.service"
SYSTEMD_SERVICE:${SRCNAME}-metadata-agent = "neutron-metadata-agent.service"
SYSTEMD_SERVICE:${SRCNAME}-setup = "neutron-init.service"

# Disable unconfigured services
SYSTEMD_AUTO_ENABLE:${SRCNAME}-server = "disable"
SYSTEMD_AUTO_ENABLE:${SRCNAME}-dhcp-agent = "disable"
SYSTEMD_AUTO_ENABLE:${SRCNAME}-linuxbridge-agent = "disable"
SYSTEMD_AUTO_ENABLE:${SRCNAME}-metadata-agent = "disable"


MONITOR_SERVICE_PACKAGES = "${SRCNAME}"
MONITOR_SERVICE_${SRCNAME} = "neutron"
