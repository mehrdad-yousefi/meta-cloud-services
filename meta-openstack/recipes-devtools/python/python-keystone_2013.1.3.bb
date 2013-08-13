DESCRIPTION = "Authentication service for OpenStack"
HOMEPAGE = "http://www.openstack.org"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

PR = "r0"
SRCNAME = "keystone"

SRC_URI = "https://launchpad.net/keystone/grizzly/${PV}/+download/${SRCNAME}-${PV}.tar.gz \
           file://keystone.conf \
           file://identity.sh \
           file://keystone \
           file://openrc \
	  "

SRC_URI[md5sum] = "49bfcd088426960ef787d040ea8426af"
SRC_URI[sha256sum] = "e097170ebb1cf22de50f2d5ab2216a5116ffe0934720dbad8b02d61c370b8261"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools update-rc.d identity

SERVICE_TOKEN = "password"

do_install_append() {

    KEYSTONE_CONF_DIR=${D}${sysconfdir}/keystone

    install -d ${KEYSTONE_CONF_DIR}

    sed -e "s:%SERVICE_TOKEN%:${SERVICE_TOKEN}:g" -i ${WORKDIR}/keystone.conf
    sed -e "s:%DB_USER%:${DB_USER}:g" -i ${WORKDIR}/keystone.conf
    sed -e "s:%DB_PASSWORD%:${DB_PASSWORD}:g" -i ${WORKDIR}/keystone.conf

    install -m 600 ${WORKDIR}/keystone.conf ${KEYSTONE_CONF_DIR}/
    install -m 600 ${WORKDIR}/identity.sh ${KEYSTONE_CONF_DIR}/
    install -m 600 ${WORKDIR}/openrc ${KEYSTONE_CONF_DIR}/
    install -m 600 ${S}/etc/logging.conf.sample ${KEYSTONE_CONF_DIR}/logging.conf
    install -m 600 ${S}/etc/policy.json ${KEYSTONE_CONF_DIR}/policy.json

    if ${@base_contains('DISTRO_FEATURES', 'sysvinit', 'true', 'false', d)}; then
        install -d ${D}${sysconfdir}/init.d
        install -m 0755 ${WORKDIR}/keystone ${D}${sysconfdir}/init.d/keystone
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

    sudo -u postgres createdb keystone
    keystone-manage db_sync
    keystone-manage pki_setup

    #Create users, services and endpoints
    /etc/init.d/keystone start
    sleep 0.25
    ADMIN_PASSWORD=${ADMIN_PASSWORD} \
    SERVICE_PASSWORD=${SERVICE_PASSWORD} \
    SERVICE_TENANT_NAME=${SERVICE_TENANT_NAME} \
        bash /etc/keystone/identity.sh
}

PACKAGES += " ${SRCNAME}"

FILES_${PN} = "${libdir}/*"

FILES_${SRCNAME} = "${bindir}/* \
    ${sysconfdir}/${SRCNAME}/* \ 
    ${sysconfdir}/init.d/* "

RDEPENDS_${PN} += "python-pam \
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
	"

RDEPENDS_${SRCNAME} = "${PN} \
        postgresql postgresql-client python-psycopg2"

INITSCRIPT_PACKAGES = "${SRCNAME}"
INITSCRIPT_NAME_${SRCNAME} = "keystone"
