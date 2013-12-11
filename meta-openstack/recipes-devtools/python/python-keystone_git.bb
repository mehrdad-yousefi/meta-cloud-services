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
	  "

SRCREV="4221b6020e6b0b42325d8904d7b8a22577a6acc0"
PV="2013.2+git${SRCPV}"

S = "${WORKDIR}/git"

inherit setuptools update-rc.d identity hosts

SERVICE_TOKEN = "password"

do_install_append() {

    KEYSTONE_CONF_DIR=${D}${sysconfdir}/keystone

    install -d ${KEYSTONE_CONF_DIR}

    sed -e "s:%SERVICE_TOKEN%:${SERVICE_TOKEN}:g" -i ${WORKDIR}/keystone.conf
    sed -e "s:%DB_USER%:${DB_USER}:g" -i ${WORKDIR}/keystone.conf
    sed -e "s:%DB_PASSWORD%:${DB_PASSWORD}:g" -i ${WORKDIR}/keystone.conf

    sed -e "s:%CONTROLLER_IP%:${CONTROLLER_IP}:g" -i ${WORKDIR}/keystone.conf
    sed -e "s:%CONTROLLER_IP%:${CONTROLLER_IP}:g" -i ${WORKDIR}/identity.sh

    install -d ${D}${localstatedir}/log/${SRCNAME}

    install -m 600 ${WORKDIR}/keystone.conf ${KEYSTONE_CONF_DIR}/
    install -m 600 ${WORKDIR}/identity.sh ${KEYSTONE_CONF_DIR}/
    install -m 600 ${WORKDIR}/openrc ${KEYSTONE_CONF_DIR}/
    install -m 600 ${S}/etc/logging.conf.sample ${KEYSTONE_CONF_DIR}/logging.conf
    install -m 600 ${S}/etc/policy.json ${KEYSTONE_CONF_DIR}/policy.json

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

PACKAGES += " ${SRCNAME}-tests ${SRCNAME} ${SRCNAME}-setup"

ALLOW_EMPTY_${SRCNAME}-setup = "1"

FILES_${PN} = "${libdir}/*"

FILES_${SRCNAME}-tests = "${sysconfdir}/${SRCNAME}/run_tests.sh"

FILES_${SRCNAME} = "${bindir}/* \
    ${sysconfdir}/${SRCNAME}/* \ 
    ${sysconfdir}/init.d/* \
    ${localstatedir}/* \
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
	python-oslo.config \
        python-dogpile.core \
        python-dogpile.cache \
	"

# TODO:
#    if DISTRO_FEATURE contains "tempest" then add *-tests to the main RDEPENDS

RDEPENDS_${SRCNAME} = "${PN} postgresql postgresql-client python-psycopg2"

INITSCRIPT_PACKAGES = "${SRCNAME}"
INITSCRIPT_NAME_${SRCNAME} = "keystone"
