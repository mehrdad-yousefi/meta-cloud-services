DESCRIPTION = "Quantum (virtual network service)"
HOMEPAGE = "https://launchpad.net/quantum"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

PR = "r0"
SRCNAME = "quantum"

SRC_URI = "https://launchpad.net/${SRCNAME}/grizzly/${PV}/+download/${SRCNAME}-${PV}.tar.gz \
      file://fix-amqlib-version.patch \
      file://quantum.conf \
      file://ovs_quantum_plugin.ini \
      file://linuxbridge_conf.ini \
      file://quantum-server.init \
      file://quantum-agent.init \
	  "

#SRC_URI[md5sum] = "06ba502f288e30519f2f13c7b189bfb8"
#SRC_URI[sha256sum] = "1fa925e2d95b7c508ad826d3020d67e1f720efa53e5c41eaca790116f2a0f691"

SRC_URI[md5sum] = "1ad2338b25cfde582de479678533113e"
SRC_URI[sha256sum] = "edae19fe45849168bc9cace82b63a11a3b9d2292ba733d4c536657c1c722e61e"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools update-rc.d

do_install_append() {

    QUANTUM_CONF_DIR=${D}${sysconfdir}/quantum

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

    # quick fix
    #exit 1
    sudo -u postgres createdb quantum
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
