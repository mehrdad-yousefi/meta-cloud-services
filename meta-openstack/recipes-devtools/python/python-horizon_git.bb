DESCRIPTION = "The OpenStack Dashboard."
HOMEPAGE = "https://github.com/openstack/horizon/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

DEPENDS += " \
        python-pip \
        python-pbr \
        "

DEPENDS_${PN} += "python-django \
    python-django-compressor \
    python-django-openstack-auth \
    python-netaddr \
    python-cinderclient \
    python-glanceclient \
    python-keystoneclient \
    python-novaclient \
    python-neutronclient \
    python-heatclient \
    python-pytz \
    python-django-appconf \
    python-six \
    python-swiftclient \
    python-lockfile \
    python-pbr \
    "

PR = "r2"
SRCNAME = "horizon"

SRC_URI = "git://github.com/openstack/${SRCNAME}.git;branch=stable/havana \
    file://horizon.init \
    file://fix_bindir_path.patch \
    file://openstack-dashboard-apache.conf \
    file://local_settings.py \
    "

SRCREV="b2259b352fd1e00a269b8275afa8093223598235"
PV="2013.2+git${SRCPV}"
S = "${WORKDIR}/git"

inherit setuptools update-rc.d python-dir default_configs

# no longer required. kept as reference.
# do_install[dirs] += "${D}/usr/share/bin"

do_install_append() {
    HORIZON_CONF_DIR=${D}${sysconfdir}/horizon

    install -d ${HORIZON_CONF_DIR}

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

    # no longer required. kept as reference.
    # mv ${D}${datadir}/bin ${DASHBOARD_DIR}/bin

    cp run_tests.sh ${HORIZON_CONF_DIR}

    # the following are setup required for horizon-apache
    install -d ${D}/usr/share/openstack-dashboard
    cp -a ${S}/openstack_dashboard ${D}/usr/share/openstack-dashboard/
    cp ${S}/manage.py ${D}/usr/share/openstack-dashboard

    install -D -m 644 ${WORKDIR}/local_settings.py \
      ${D}/etc/openstack-dashboard/local_settings.py
    ln -fs /etc/openstack-dashboard/local_settings.py \
      ${D}/usr/share/openstack-dashboard/openstack_dashboard/local/local_settings.py

    install -D -m 644 ${WORKDIR}/openstack-dashboard-apache.conf \
      ${D}/etc/apache2/conf.d/openstack-dashboard-apache.conf
    sed -i -e 's#%PYTHON_SITEPACKAGES%#${PYTHON_SITEPACKAGES_DIR}#' ${D}/etc/apache2/conf.d/openstack-dashboard-apache.conf

    ln -fs openstack_dashboard/static ${D}/usr/share/openstack-dashboard/static

    # daemon is UID 1
    chown -R 1 ${D}/usr/share/openstack-dashboard/openstack_dashboard/static
}

PACKAGES += "${SRCNAME}-tests ${SRCNAME} ${SRCNAME}-apache ${SRCNAME}-standalone"

FILES_${PN} = "${libdir}/*"

FILES_${SRCNAME}-tests = "${sysconfdir}/${SRCNAME}/run_tests.sh"

FILES_${SRCNAME} = "${bindir}/* \
    ${datadir}/* \
    "

FILES_${SRCNAME}-standalone = "${sysconfdir}/init.d/horizon"

FILES_${SRCNAME}-apache = "/etc/apache2 \
    /etc/openstack-dashboard/ \
    /usr/share/openstack-dashboard/ \
    "

RDEP_ARCH_VAR = ""
RDEP_ARCH_VAR_arm = "nodejs"
RDEP_ARCH_VAR_i686 = "nodejs"
RDEP_ARCH_VAR_x86-64 = "nodejs"
RDEP_ARCH_VAR_ia32 = "nodejs"

RDEPENDS_${PN} += " python-django \
    python-django-appconf \
    python-django-compressor \
    python-django-openstack-auth \
    python-netaddr \
    python-ceilometerclient \
    python-cinderclient \
    python-glanceclient \
    python-heatclient \
    python-keystoneclient \
    python-lesscpy \
    python-novaclient \
    python-neutronclient \
    python-pytz \
    python-six \
    python-swiftclient \
    python-lockfile \
    python-pyyaml \
    ${RDEP_ARCH_VAR} \
    "

RDEPENDS_${SRCNAME} = "${PN}"

INITSCRIPT_PACKAGES = "${SRCNAME}"
INITSCRIPT_NAME_${SRCNAME} = "horizon"
INITSCRIPT_PARAMS_${SRCNAME} = "${OS_DEFAULT_INITSCRIPT_PARAMS}"

RDEPENDS_${SRCNAME}-apache = "\
    apache2 \
    mod-wsgi \
    python-lesscpy \
    memcached \
    python-memcached \
    "
