DESCRIPTION = "Authentication service for OpenStack"
HOMEPAGE = "http://www.openstack.org"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

PR = "r0"
SRCNAME = "keystone"

SRC_URI = "https://launchpad.net/keystone/grizzly/${PV}/+download/${SRCNAME}-${PV}.tar.gz \
           file://keystone.conf \
		  "

SRC_URI[md5sum] = "f82189cd7e3f0955e32c60e41f4120da"
SRC_URI[sha256sum] = "34347a3242a40d93b98c3722e6f3fbc112bc1c9ef20c045c3d40637e459b4574"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

do_install_append() {

    KEYSTONE_CONF_DIR=${D}${sysconfdir}/keystone

    install -d ${KEYSTONE_CONF_DIR}

    install -m 600 ${WORKDIR}/keystone.conf ${KEYSTONE_CONF_DIR}/
    install -m 600 ${S}/etc/logging.conf.sample ${KEYSTONE_CONF_DIR}/logging.conf
    install -m 600 ${S}/etc/policy.json ${KEYSTONE_CONF_DIR}/policy.json

    # Create the sqlite database
    touch ${KEYSTONE_CONF_DIR}/keystone.db
}

pkg_postinst_${PN} () {
    if [ "x$D" != "x" ]; then
        exit 1
    fi

    # Needed when using a MySQL backend
    # mysql -u root -e "CREATE DATABASE keystone CHARACTER SET utf8;"
    keystone-manage db_sync
    keystone-manage pki_setup
}

FILES_${PN} += "${sysconfdir}/${SRCNAME}/*"

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
