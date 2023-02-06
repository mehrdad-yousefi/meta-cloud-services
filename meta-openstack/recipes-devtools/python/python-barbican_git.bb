DESCRIPTION = "Barbican is a ReST API designed for the secure storage, provisioning and management of secrets."
HOMEPAGE = "https://wiki.openstack.org/wiki/Barbican"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fc8be9e7dffe97390d1216b01fd0be01"

PR = "r0"
SRCNAME = "barbican"
BARBICAN_MAX_PACKET_SIZE ?= "65535"

SRC_URI = "git://github.com/openstack/barbican.git;branch=master;protocol=https \
           file://barbican.init \
           file://barbican-increase-buffer-size-to-support-PKI-tokens.patch \
           file://barbican-fix-path-to-find-configuration-files.patch \
           file://barbican-handle-white-space-in-date-strings.patch \
          "

SRCREV = "e6f05febbe18a86e4e6b05acc5f4868fa3beb291"
PV = "2015.1.0+git${SRCPV}"
S = "${WORKDIR}/git"

inherit update-rc.d setuptools3 identity hosts useradd default_configs monitor

SERVICECREATE_PACKAGES = "${SRCNAME}-setup"
KEYSTONE_HOST="${CONTROLLER_IP}"

# USERCREATE_PARAM and SERVICECREATE_PARAM contain the list of parameters to be set.
# If the flag for a parameter in the list is not set here, the default value will be given to that parameter.
# Parameters not in the list will be set to empty.

USERCREATE_PARAM_${SRCNAME}-setup = "name pass tenant role email"
SERVICECREATE_PARAM_${SRCNAME}-setup = "name type description region publicurl adminurl internalurl"
python () {
    flags = {'type':'keystore',\
             'description':'Barbican Key Management Service',\
             'publicurl':"'http://${KEYSTONE_HOST}:9311/v1'",\
             'adminurl':"'http://${KEYSTONE_HOST}:9312/v1'",\
             'internalurl':"'http://${KEYSTONE_HOST}:9313/v1'"}
    d.setVarFlags("SERVICECREATE_PARAM_%s-setup" % d.getVar('SRCNAME',True), flags)
}
SERVICECREATE_PACKAGES[vardeps] += "KEYSTONE_HOST"

do_install:append() {
    TEMPLATE_CONF_DIR=${S}${sysconfdir}/${SRCNAME}
    BARBICAN_CONF_DIR=${D}${sysconfdir}/${SRCNAME}

    install -d ${BARBICAN_CONF_DIR}
    cp -r ${TEMPLATE_CONF_DIR}/* ${BARBICAN_CONF_DIR}

    install -d ${D}${localstatedir}/lib/barbican
    sed -e "s:%BARBICAN_MAX_PACKET_SIZE%:${BARBICAN_MAX_PACKET_SIZE}:g" -i ${BARBICAN_CONF_DIR}/vassals/barbican-api.ini
    sed -e "s:%BARBICAN_MAX_PACKET_SIZE%:${BARBICAN_MAX_PACKET_SIZE}:g" -i ${BARBICAN_CONF_DIR}/vassals/barbican-admin.ini
    install -d ${D}${sysconfdir}/init.d

    for binary in api; do
	sed "s:@suffix@:$binary:" < ${WORKDIR}/barbican.init >${WORKDIR}/barbican-$binary.init.sh
	sed -e "s:%BARBICAN_MAX_PACKET_SIZE%:${BARBICAN_MAX_PACKET_SIZE}:g" -i ${WORKDIR}/barbican-$binary.init.sh
        install -m 0755 ${WORKDIR}/barbican-$binary.init.sh ${D}${sysconfdir}/init.d/barbican-$binary
    done
    rm -f ${D}/usr/bin/barbican.sh
    rm -f ${D}/usr/bin/barbican-worker.py

    sed -e "s:%BARBICAN_CONF_DIR%:${sysconfdir}/${SRCNAME}:g" \
        -i ${D}/${PYTHON_SITEPACKAGES_DIR}/${SRCNAME}/tests/api/test_resources_policy.py
}

USERADD_PACKAGES = "${PN}"
GROUPADD_PARAM:${PN} = "--system barbican"
USERADD_PARAM:${PN}  = "--system --home /var/lib/barbican -g barbican \
                        --no-create-home --shell /bin/false barbican"

PACKAGES += "${SRCNAME} \
             ${SRCNAME}-setup "

FILES:${PN} = "${libdir}/* \
"
FILES:${SRCNAME} = "${sysconfdir}/${SRCNAME}/* \
                    ${sysconfdir}/init.d/barbican-api \
	            ${bindir} \
	            ${bindir}/* \
                    ${localstatedir}/* \
"

ALLOW_EMPTY:${SRCNAME}-setup = "1"
pkg_postinst:${SRCNAME}-setup () {
    if [ -z "$D" ]; then
        chown -R barbican:barbican ${sysconfdir}/${SRCNAME}
        chown -R barbican:barbican ${localstatedir}/lib/barbican
    fi
}

DEPENDS += " \
        python3-pip \
        python3-pbr \
        "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python3-pbr-native \
        "

RDEPENDS:${SRCNAME} = "${PN} \
                       ${SRCNAME}-setup \
                       uwsgi \
                       python3-falcon \
                       python3-oslo.messaging \
                       bash \
                      "

RDEPENDS:${PN} += " \
        python3-pip \
        python3-pbr \
        python3-alembic \
        python3-babel \
        python3-eventlet \
        python3-falcon \
        python3-iso8601 \
        python3-jsonschema \
        python3-kombu \
        python3-netaddr \
        python3-pastedeploy \
        python3-paste \
        python3-pycryptodome \
        python3-keystoneclient \
        python3-sqlalchemy \
        python3-stevedore \
        python3-webob \
        python3-barbicanclient \
        bash \
        "

INITSCRIPT_PACKAGES = "${SRCNAME}"
INITSCRIPT_NAME:${SRCNAME} = "barbican-api"
INITSCRIPT_PARAMS:${SRCNAME} = "${OS_DEFAULT_INITSCRIPT_PARAMS}"

MONITOR_SERVICE_PACKAGES = "${SRCNAME}"
MONITOR_SERVICE_${SRCNAME} = "barbican"
