DESCRIPTION = "The OpenStack Dashboard."
HOMEPAGE = "https://github.com/openstack/horizon/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

DEPENDS_${PN} += "python-django \
    python-django-compressor \
    python-django-openstack-auth \
    python-netaddr \
    python-cinderclient \
    python-glanceclient \
    python-keystoneclient \
    python-novaclient \
    python-quantumclient \
    python-pytz \
    python-django-appconf \
    python-six \
    python-swiftclient \
    python-lockfile \
    "

PR = "r0"
SRCNAME = "horizon"

SRC_URI = "https://launchpad.net/horizon/grizzly/${PV}/+download/${SRCNAME}-${PV}.tar.gz \
    file://horizon.init \
    file://fix_bindir_path.patch \
    "

SRC_URI[md5sum] = "8edb861987dffe3017eada91d3009f0a"
SRC_URI[sha256sum] = "4dbf05e75313d9d6ac966de1d139f26647ab537a3d1f418a3e4424210b4c05fd"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools update-rc.d python-dir

do_install_append() {
    DASHBOARD_DIR=${D}${PYTHON_SITEPACKAGES_DIR}/openstack_dashboard
    sed -e "s:^LANGUAGE_CODE =.*:LANGUAGE_CODE = 'en-us':g" \
        -i ${DASHBOARD_DIR}/settings.py
    sed -e "s:^# from horizon.utils:from horizon.utils:g" \
        ${DASHBOARD_DIR}/local/local_settings.py.example > ${DASHBOARD_DIR}/local/local_settings.py
    sed -e "s:^# SECRET_KEY =:SECRET_KEY =:g" \
        -i ${DASHBOARD_DIR}/local/local_settings.py
    install -m 644 ${S}/manage.py ${DASHBOARD_DIR}/manage.py

    if ${@base_contains('DISTRO_FEATURES', 'sysvinit', 'true', 'false', d)}; then
        install -d ${D}${sysconfdir}/init.d
        sed 's:@PYTHON_SITEPACKAGES@:${PYTHON_SITEPACKAGES_DIR}:' ${WORKDIR}/horizon.init >${WORKDIR}/horizon
        install -m 0755 ${WORKDIR}/horizon ${D}${sysconfdir}/init.d/horizon
    fi

    mv ${D}${datadir}/bin ${DASHBOARD_DIR}/bin
}

PACKAGES += "${SRCNAME}"

FILES_${PN} = "${libdir}/*"

FILES_${SRCNAME} = "${bindir}/* \
    ${sysconfdir}/init.d/* \
    ${datadir}/* \
    "

RDEPENDS_${PN} += "nodejs \
    python-django \
    python-django-appconf \
    python-django-compressor \
    python-django-openstack-auth \
    python-netaddr \
    python-cinderclient \
    python-glanceclient \
    python-keystoneclient \
    python-novaclient \
    python-quantumclient \
    python-pytz \
    python-six \
    python-swiftclient \
    python-lockfile \
    "

RDEPENDS_${SRCNAME} = "${PN}"

INITSCRIPT_PACKAGES = "${SRCNAME}"
INITSCRIPT_NAME_${SRCNAME} = "horizon"
