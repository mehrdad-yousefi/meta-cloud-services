DESCRIPTION = "Authentication service for OpenStack"
HOMEPAGE = "http://www.openstack.org"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

PR = "r0"
SRCNAME = "keystone"

SRC_URI = "git://github.com/openstack/${SRCNAME}.git;branch=stable/havana \
           file://keystone.conf \
           file://identity.sh \
           file://keystone \
           file://openrc \
           file://keystone-search-in-etc-directory-for-config-files.patch \
           "

SRCREV="a96d1a44bc0f074729c312e5c2a0f0875edf1765"
PV="2013.2.2+git${SRCPV}"

S = "${WORKDIR}/git"

inherit setuptools update-rc.d identity hosts default_configs

SERVICE_TOKEN = "password"
TOKEN_FORMAT ?= "PKI"

do_install_append() {

    KEYSTONE_CONF_DIR=${D}${sysconfdir}/keystone

    install -m 750 -d ${KEYSTONE_CONF_DIR}

    install -d ${D}${localstatedir}/log/${SRCNAME}

    install -m 600 ${WORKDIR}/keystone.conf ${KEYSTONE_CONF_DIR}/
    install -m 600 ${WORKDIR}/identity.sh ${KEYSTONE_CONF_DIR}/
    install -m 600 ${WORKDIR}/openrc ${KEYSTONE_CONF_DIR}/
    install -m 600 ${S}/etc/logging.conf.sample ${KEYSTONE_CONF_DIR}/logging.conf
    install -m 600 ${S}/etc/policy.json ${KEYSTONE_CONF_DIR}/policy.json
    install -m 600 ${S}/etc/keystone.conf.sample ${KEYSTONE_CONF_DIR}/keystone.conf.sample
    install -m 600 ${S}/etc/keystone-paste.ini ${KEYSTONE_CONF_DIR}/keystone-paste.ini

    sed -e "s:%SERVICE_TOKEN%:${SERVICE_TOKEN}:g" -i ${KEYSTONE_CONF_DIR}/keystone.conf
    sed -e "s:%DB_USER%:${DB_USER}:g" -i ${KEYSTONE_CONF_DIR}/keystone.conf
    sed -e "s:%DB_PASSWORD%:${DB_PASSWORD}:g" -i ${KEYSTONE_CONF_DIR}/keystone.conf

    sed -e "s:%CONTROLLER_IP%:${CONTROLLER_IP}:g" -i ${KEYSTONE_CONF_DIR}/keystone.conf
    sed -e "s:%CONTROLLER_IP%:${CONTROLLER_IP}:g" -i ${KEYSTONE_CONF_DIR}/identity.sh

    sed -e "s:%TOKEN_FORMAT%:${TOKEN_FORMAT}:g" -i ${KEYSTONE_CONF_DIR}/keystone.conf

    if ${@base_contains('DISTRO_FEATURES', 'sysvinit', 'true', 'false', d)}; then
        install -d ${D}${sysconfdir}/init.d
        install -m 0755 ${WORKDIR}/keystone ${D}${sysconfdir}/init.d/keystone
    fi

    cp run_tests.sh ${KEYSTONE_CONF_DIR}
}

pkg_postinst_${SRCNAME}-setup () {
    # python-keystone postinst start
    if [ "x$D" != "x" ]; then
        exit 1
    fi

    # This is to make sure postgres is configured and running
    if ! pidof postmaster > /dev/null; then
        /etc/init.d/postgresql-init
        /etc/init.d/postgresql start
        sleep 2
    fi

    sudo -u postgres createdb keystone
    keystone-manage db_sync
    keystone-manage pki_setup --keystone-user=root --keystone-group=root

    # Create users, services and endpoints
    /etc/init.d/keystone start
    sleep 2

    ADMIN_PASSWORD=${ADMIN_PASSWORD} \
    SERVICE_PASSWORD=${SERVICE_PASSWORD} \
    SERVICE_TENANT_NAME=${SERVICE_TENANT_NAME} \
             bash /etc/keystone/identity.sh

    # end python-keystone postinst
}

# By default tokens are expired after 1 day so by default we can set
# this token flush cronjob to run every 2 days
KEYSTONE_TOKEN_FLUSH_TIME ??= "0 0 */2 * *"

pkg_postinst_${SRCNAME}-cronjobs () {
    # By default keystone expired tokens are not automatic removed out of the
    # database.  So we create a cronjob for cleaning these expired tokens.
    echo "${KEYSTONE_TOKEN_FLUSH_TIME} root /usr/bin/keystone-manage token_flush" >> /etc/crontab
}

PACKAGES += " ${SRCNAME}-tests ${SRCNAME} ${SRCNAME}-setup ${SRCNAME}-cronjobs"

ALLOW_EMPTY_${SRCNAME}-setup = "1"

ALLOW_EMPTY_${SRCNAME}-cronjobs = "1"

FILES_${PN} = "${libdir}/*"

FILES_${SRCNAME}-tests = "${sysconfdir}/${SRCNAME}/run_tests.sh"

FILES_${SRCNAME} = "${bindir}/* \
    ${sysconfdir}/${SRCNAME}/* \ 
    ${sysconfdir}/init.d/* \
    ${localstatedir}/* \
    "

DEPENDS += " \
        python-pip \
        python-pbr \
        "

RDEPENDS_${PN} += " \
        python-pam \
        python-webob \
        python-eventlet \
        python-greenlet \
        python-pastedeploy \
        python-paste \
        python-routes \
        python-sqlalchemy \
        python-sqlalchemy-migrate \
        python-passlib \
        python-lxml \
        python-iso8601 \
        python-keystoneclient \
        python-openstack-nose \
        python-oslo.config \
        python-dogpile.core \
        python-dogpile.cache \
        python-pbr \
        "

# TODO:
#    if DISTRO_FEATURE contains "tempest" then add *-tests to the main RDEPENDS

RDEPENDS_${SRCNAME} = "${PN} postgresql postgresql-client python-psycopg2"
RDEPENDS_${SRCNAME}-setup = "postgresql sudo ${SRCNAME}"
RDEPENDS_${SRCNAME}-cronjobs = "cronie ${SRCNAME}"

INITSCRIPT_PACKAGES = "${SRCNAME}"
INITSCRIPT_NAME_${SRCNAME} = "keystone"
INITSCRIPT_PARAMS_${SRCNAME} = "${OS_DEFAULT_INITSCRIPT_PARAMS}"
