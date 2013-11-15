DESCRIPTION = "The OpenStack Integration Test Suite"
HOMEPAGE = "https://launchpad.net/tempest"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

PR = "r0"
SRCNAME = "tempest"

SRC_URI = "git://github.com/openstack/${SRCNAME}.git;branch=stable/havana \
           file://tempest.conf \
           file://logging.conf \
"

SRCREV="6273339e2da725b01560b6a2db11a3bf7a6659d7"
PV="2013.2+git${SRCPV}"
S = "${WORKDIR}/git"

do_install_append() {
    TEMPLATE_CONF_DIR=${S}${sysconfdir}/
    TEMPEST_CONF_DIR=${D}${sysconfdir}/${SRCNAME}

    sed -e "s:%SERVICE_TENANT_NAME%:${SERVICE_TENANT_NAME}:g" -i ${WORKDIR}/tempest.conf
    sed -e "s:%SERVICE_USER%:${SRCNAME}:g" -i ${WORKDIR}/tempest.conf
    sed -e "s:%SERVICE_PASSWORD%:${SERVICE_PASSWORD}:g" -i ${WORKDIR}/tempest.conf

    sed -e "s:%DB_USER%:${DB_USER}:g" -i ${WORKDIR}/tempest.conf
    sed -e "s:%DB_PASSWORD%:${DB_PASSWORD}:g" -i ${WORKDIR}/tempest.conf

    sed -e "s:%CONTROLLER_IP%:${CONTROLLER_IP}:g" -i ${WORKDIR}/tempest.conf
    sed -e "s:%CONTROLLER_HOST%:${CONTROLLER_HOST}:g" -i ${WORKDIR}/tempest.conf

    sed -e "s:%COMPUTE_IP%:${COMPUTE_IP}:g" -i ${WORKDIR}/tempest.conf
    sed -e "s:%COMPUTE_HOST%:${COMPUTE_HOST}:g" -i ${WORKDIR}/tempest.conf

    sed -e "s:%ADMIN_PASSWORD%:${ADMIN_PASSWORD}:g" -i ${WORKDIR}/tempest.conf
    sed -e "s:%SERVICE_TENANT_NAME%:${SERVICE_TENANT_NAME}:g" -i ${WORKDIR}/tempest.conf

    install -d ${TEMPEST_CONF_DIR}
    install -m 600 ${WORKDIR}/tempest.conf ${TEMPEST_CONF_DIR}
    install -m 600 ${WORKDIR}/logging.conf ${TEMPEST_CONF_DIR}
    install -m 600 ${TEMPLATE_CONF_DIR}/*.yaml ${TEMPEST_CONF_DIR}
}

pkg_postinst_${SRCNAME}() {
    if [ "x$D" != "x" ]; then
        exit 1
    fi
    
    # This is to make sure postgres is configured and running
    if ! pidof postmaster > /dev/null; then
       /etc/init.d/postgresql-init
       /etc/init.d/postgresql start
       sleep 5
    fi
}

inherit setuptools identity hosts

# PACKAGES += "${SRCNAME}-common ${SRCNAME}-api ${SRCNAME}-api-cfn ${SRCNAME}-engine"

FILES_${PN} = "${libdir}/* \
               ${sysconfdir}/* \
"

RDEPENDS_${PN} += " \
        python-testrepository \
        python-fixtures \
        python-keyring \
	python-glanceclient \
	python-keystoneclient \
	python-swiftclient \
        python-novaclient \
        python-cinderclient \
        python-heatclient \
        python-pbr \
        python-anyjson \
        python-nose \
        python-httplib2 \
        python-jsonschema \
        python-testtools \
        python-lxml \
        python-boto \
        python-paramiko \
        python-netaddr \
        python-testresources \
        python-oslo.config \
        python-eventlet \
        python-six \
        python-iso8601 \
        python-mimeparse \
	"

