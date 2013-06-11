DESCRIPTION = "Services for discovering, registering and retrieving virtual machine images"
HOMEPAGE = "http://glance.openstack.org/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

PR = "r0"
SRCNAME = "glance"

SRC_URI = "https://launchpad.net/glance/grizzly/${PV}/+download/${SRCNAME}-${PV}.tar.gz \
           file://glance-api.conf \
           file://glance-cache.conf \
           file://glance-registry.conf \
           "

SRC_URI[md5sum] = "cd813098ca807bed67440bb1646d0647"
SRC_URI[sha256sum] = "f4deee125ee6729daee5315c6aacd9e265c3015692a62ae6aefeadbd3fef7f70"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

do_install_append() {

    GLANCE_CONF_DIR=${D}${sysconfdir}/glance

    install -d ${GLANCE_CONF_DIR}

    install -m 600 ${WORKDIR}/glance-registry.conf ${GLANCE_CONF_DIR}/
    install -m 600 ${WORKDIR}/glance-api.conf ${GLANCE_CONF_DIR}/
    install -m 600 ${WORKDIR}/glance-cache.conf ${GLANCE_CONF_DIR}/

    install -m 600 ${S}/etc/glance-registry-paste.ini ${GLANCE_CONF_DIR}/
    install -m 600 ${S}/etc/glance-api-paste.ini ${GLANCE_CONF_DIR}/
    install -m 600 ${S}/etc/policy.json ${GLANCE_CONF_DIR}/

    install -d ${GLANCE_CONF_DIR}/images
    install -d ${D}${localstatedir}/lib/glance/image_cache

    install -d ${D}${localstatedir}/log/${SRCNAME}

    # Create the sqlite database
    touch ${GLANCE_CONF_DIR}/glance.db
}

pkg_postinst_${PN} () {
    if [ "x$D" != "x" ]; then
        exit 1
    fi
    
    mkdir /var/log/glance
    # Needed when using a MySQL backend
    # mysql -u root -e "CREATE DATABASE glance CHARACTER SET utf8;"
    sudo -u postgres createdb glance
    glance-manage db_sync
}

FILES_${PN} += "${sysconfdir}/${SRCNAME}/* \
               ${localstatedir}/lib/${SRCNAME}/*"

RDEPENDS_${PN} += "python-greenlet \
	python-sqlalchemy \
	python-anyjson \
	python-eventlet \
	python-pastedeploy \
	python-routes \
	python-webob \
	python-boto \
	python-sqlalchemy-migrate \
	python-httplib2 \
	python-kombu \
	python-iso8601 \
	python-oslo.config \
	python-lxml \
	python-paste \
	python-pycrypto \
	python-jsonschema \
	python-keystoneclient \
	python-swiftclient \
	"
