DESCRIPTION = "Barbican is a ReST API designed for the secure storage, provisioning and management of secrets."
HOMEPAGE = "https://wiki.openstack.org/wiki/Barbican"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fc8be9e7dffe97390d1216b01fd0be01"

PR = "r0"
SRCNAME = "barbican"
BARBICAN_MAX_PACKET_SIZE ?= "65535"

SRC_URI = "git://github.com/openstack/barbican.git;branch=master \
           file://barbican.init \
           file://barbican-increase-buffer-size-to-support-PKI-tokens.patch \
          "

SRCREV="177d4499af6b261f48814503e3565f433e86cc66"
PV="2014.1+git${SRCPV}"
S = "${WORKDIR}/git"

inherit update-rc.d setuptools identity hosts useradd default_configs

do_install_append() {
    TEMPLATE_CONF_DIR=${S}${sysconfdir}/${SRCNAME}
    BARBICAN_CONF_DIR=${D}${sysconfdir}/${SRCNAME}

    install -d ${BARBICAN_CONF_DIR}
    cp -r ${TEMPLATE_CONF_DIR}/* ${BARBICAN_CONF_DIR}

    install -d ${D}${localstatedir}/lib/barbican

    sed -e "s:%BARBICAN_MAX_PACKET_SIZE%:${BARBICAN_MAX_PACKET_SIZE}:g" -i ${BARBICAN_CONF_DIR}/vassals/barbican-api.ini
    sed -e "s:%BARBICAN_MAX_PACKET_SIZE%:${BARBICAN_MAX_PACKET_SIZE}:g" -i ${BARBICAN_CONF_DIR}/vassals/barbican-admin.ini

    if ${@base_contains('DISTRO_FEATURES', 'sysvinit', 'true', 'false', d)}; then
        install -d ${D}${sysconfdir}/init.d

	for binary in api; do
	    sed "s:@suffix@:$binary:" < ${WORKDIR}/barbican.init >${WORKDIR}/barbican-$binary.init.sh
	    sed -e "s:%BARBICAN_MAX_PACKET_SIZE%:${BARBICAN_MAX_PACKET_SIZE}:g" -i ${WORKDIR}/barbican-$binary.init.sh
            install -m 0755 ${WORKDIR}/barbican-$binary.init.sh ${D}${sysconfdir}/init.d/barbican-$binary
	done
	rm -f ${D}/usr/bin/barbican.sh
	rm -f ${D}/usr/bin/barbican-worker.py
    fi
}

USERADD_PACKAGES = "${PN}"
GROUPADD_PARAM_${PN} = "--system barbican"
USERADD_PARAM_${PN}  = "--system --home /var/lib/barbican -g barbican \
                        --no-create-home --shell /bin/false barbican"

PACKAGES += "${SRCNAME} \
             ${SRCNAME}-setup "

FILES_${PN} = "${libdir}/* \
"
FILES_${SRCNAME} = "${sysconfdir}/${SRCNAME}/* \
                    ${sysconfdir}/init.d/barbican-api \
	            ${bindir} \
	            ${bindir}/* \
                    ${localstatedir}/* \
"

ALLOW_EMPTY_${SRCNAME}-setup = "1"
pkg_postinst_${SRCNAME}-setup () {
    if [ "x$D" != "x" ]; then
        exit 1
    fi

    chown -R barbican:barbican ${sysconfdir}/${SRCNAME}
    chown -R barbican:barbican ${localstatedir}/lib/barbican
}

DEPENDS += " \
        python-pip \
        python-pbr \
        "

RDEPENDS_${SRCNAME} = "${PN} \
                       ${SRCNAME}-setup \
                       uwsgi \
                       python-falcon \
                       python-oslo.messaging"

RDEPENDS_${PN} += " \
        python-pip \
        python-pbr \
        python-alembic \
        python-babel \
        python-eventlet \
        python-falcon \
        python-iso8601 \
        python-jsonschema \
        python-kombu \
        python-netaddr \
        python-pastedeploy \
        python-paste \
        python-pycrypto \
        python-pysqlite \
        python-keystoneclient \
        python-sqlalchemy \
        python-stevedore \
        python-webob \
        python-wsgiref \
        "

INITSCRIPT_PACKAGES = "${SRCNAME}"
INITSCRIPT_NAME_${SRCNAME} = "barbican-api"
INITSCRIPT_PARAMS_${SRCNAME} = "${OS_DEFAULT_INITSCRIPT_PARAMS}"
