DESCRIPTION = "Services for discovering, registering and retrieving virtual machine images"
HOMEPAGE = "http://glance.openstack.org/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

PR = "r0"
SRCNAME = "glance"

SRC_URI = "git://github.com/openstack/${SRCNAME}.git;branch=stable/havana \
           file://glance.init \
           "

SRCREV="1690a739cd94efe6cb2af8e794a4acdf59de54cd"
PV="2013.2.2+git${SRCPV}"

S = "${WORKDIR}/git"

inherit setuptools update-rc.d identity default_configs

GLANCE_DEFAULT_STORE ?= "file"

do_install_append() {
    TEMPLATE_CONF_DIR=${S}${sysconfdir}
    GLANCE_CONF_DIR=${D}${sysconfdir}/glance

    for file in api registry cache
    do
        sed -e "s:%SERVICE_TENANT_NAME%:${SERVICE_TENANT_NAME}:g" \
            ${TEMPLATE_CONF_DIR}/glance-$file.conf > ${WORKDIR}/glance-$file.conf
        sed -e "s:%SERVICE_USER%:${SRCNAME}:g" -i ${WORKDIR}/glance-$file.conf
        sed -e "s:%SERVICE_PASSWORD%:${SERVICE_PASSWORD}:g" \
            -i ${WORKDIR}/glance-$file.conf
        sed -e "s#^sql_conn.*#sql_connection = postgresql://${DB_USER}:${DB_PASSWORD}@localhost/glance#g" \
            -i ${WORKDIR}/glance-$file.conf
    done
    sed -e "s:^filesystem_store_datadir =.*:filesystem_store_datadir = ${sysconfdir}/${SRCNAME}/images/:g" \
        -i ${WORKDIR}/glance-api.conf

    # send samples to rabbitmq for ceilometer integration
    sed -e "s:^notifier_strategy = noop:notifier_strategy = rabbit:g" \
        -i ${WORKDIR}/glance-api.conf         

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

    if ${@base_contains('DISTRO_FEATURES', 'sysvinit', 'true', 'false', d)}; then
        install -d ${D}${sysconfdir}/init.d
        sed 's:@suffix@:api:' < ${WORKDIR}/glance.init >${WORKDIR}/glance-api.init.sh
        install -m 0755 ${WORKDIR}/glance-api.init.sh ${D}${sysconfdir}/init.d/glance-api
        sed 's:@suffix@:registry:' < ${WORKDIR}/glance.init >${WORKDIR}/glance-registry.init.sh
        install -m 0755 ${WORKDIR}/glance-registry.init.sh ${D}${sysconfdir}/init.d/glance-registry
    fi

    sed 's:^default_store =.*:default_store = ${GLANCE_DEFAULT_STORE}:g' -i ${WORKDIR}/glance-api.conf

    cp run_tests.sh ${GLANCE_CONF_DIR}
}

pkg_postinst_${SRCNAME}-setup () {
    if [ "x$D" != "x" ]; then
        exit 1
    fi
    
    # This is to make sure postgres is configured and running
    if ! pidof postmaster > /dev/null; then
       /etc/init.d/postgresql-init
       /etc/init.d/postgresql start
       sleep 5
    fi
    
    mkdir /var/log/glance
    sudo -u postgres createdb glance
    glance-manage db_sync
}

PACKAGES += " ${SRCNAME}-tests ${SRCNAME} ${SRCNAME}-setup ${SRCNAME}-api ${SRCNAME}-registry"
ALLOW_EMPTY_${SRCNAME}-setup = "1"

FILES_${PN} = "${libdir}/*"

FILES_${SRCNAME}-tests = "${sysconfdir}/${SRCNAME}/run_tests.sh"

FILES_${SRCNAME} = "${bindir}/* \
    ${sysconfdir}/${SRCNAME}/* \
    ${localstatedir}/* \
    "

FILES_${SRCNAME}-api = "${bindir}/glance-api \
    ${sysconfdir}/init.d/glance-api \
    "

FILES_${SRCNAME}-registry = "${bindir}/glance-registry \
    ${sysconfdir}/init.d/glance-registry \
    "

DEPENDS += " \
        python-pip \
        python-pbr \
        "

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
	python-pip \
	python-lxml \
	python-paste \
	python-pycrypto \
	python-jsonschema \
	python-keystoneclient \
	python-swiftclient \
	python-pbr \
	"

RDEPENDS_${SRCNAME} = "${PN} \
        postgresql postgresql-client python-psycopg2"
RDEPENDS_${SRCNAME}-api = "${SRCNAME}"
RDEPENDS_${SRCNAME}-registry = "${SRCNAME}"
RDEPENDS_${SRCNAME}-setup = "postgresql sudo ${SRCNAME}"

INITSCRIPT_PACKAGES = "${SRCNAME}-api ${SRCNAME}-registry"
INITSCRIPT_NAME_${SRCNAME}-api = "glance-api"
INITSCRIPT_PARAMS_${SRCNAME}-api = "${OS_DEFAULT_INITSCRIPT_PARAMS}"
INITSCRIPT_NAME_${SRCNAME}-registry = "glance-registry"
INITSCRIPT_PARAMS_${SRCNAME}-registry = "${OS_DEFAULT_INITSCRIPT_PARAMS}"
