DESCRIPTION = "OpenStack Orchestration"
HOMEPAGE = "https://launchpad.net/heat"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

PR = "r0"
SRCNAME = "heat"

SRC_URI = "git://github.com/openstack/${SRCNAME}.git;branch=stable/havana \
           file://heat.conf \
           file://heat.init \
           file://autoscaling_example.template \
           file://one_vm_example.template \
           file://two_vms_example.template \
"

SRCREV="58de9e6415f5bdabde708c8584b21b59b7e96a88"
PV="2013.2.3+git${SRCPV}"
S = "${WORKDIR}/git"

do_install_append() {
    TEMPLATE_CONF_DIR=${S}${sysconfdir}/${SRCNAME}
    HEAT_CONF_DIR=${D}${sysconfdir}/${SRCNAME}

    install -d ${HEAT_CONF_DIR}
    install -m 600 ${WORKDIR}/heat.conf ${HEAT_CONF_DIR}
    install -m 600 ${TEMPLATE_CONF_DIR}/*.json ${HEAT_CONF_DIR}
    install -d ${HEAT_CONF_DIR}/templates
    install -m 600 ${TEMPLATE_CONF_DIR}/templates/* ${HEAT_CONF_DIR}/templates
    install -m 600 ${WORKDIR}/*.template ${HEAT_CONF_DIR}/templates
    install -d ${HEAT_CONF_DIR}/environment.d
    install -m 600 ${TEMPLATE_CONF_DIR}/environment.d/* ${HEAT_CONF_DIR}/environment.d
    install -m 664 ${TEMPLATE_CONF_DIR}/api-paste.ini ${HEAT_CONF_DIR}

    sed -e "s:%SERVICE_TENANT_NAME%:${SERVICE_TENANT_NAME}:g" \
        -i ${HEAT_CONF_DIR}/api-paste.ini
    sed -e "s:%SERVICE_USER%:${SRCNAME}:g" -i ${HEAT_CONF_DIR}/api-paste.ini
    sed -e "s:%SERVICE_PASSWORD%:${SERVICE_PASSWORD}:g" -i ${HEAT_CONF_DIR}/api-paste.ini
    sed -e "s:%CONTROLLER_IP%:${CONTROLLER_IP}:g" -i ${HEAT_CONF_DIR}/api-paste.ini

    sed -e "s:%DB_USER%:${DB_USER}:g" -i ${HEAT_CONF_DIR}/heat.conf
    sed -e "s:%DB_PASSWORD%:${DB_PASSWORD}:g" -i ${HEAT_CONF_DIR}/heat.conf

    sed -e "s:%CONTROLLER_IP%:${CONTROLLER_IP}:g" -i ${HEAT_CONF_DIR}/heat.conf
    sed -e "s:%CONTROLLER_HOST%:${CONTROLLER_HOST}:g" -i ${HEAT_CONF_DIR}/heat.conf

    sed -e "s:%COMPUTE_IP%:${COMPUTE_IP}:g" -i ${HEAT_CONF_DIR}/heat.conf
    sed -e "s:%COMPUTE_HOST%:${COMPUTE_HOST}:g" -i ${HEAT_CONF_DIR}/heat.conf

    sed -e "s:%ADMIN_PASSWORD%:${ADMIN_PASSWORD}:g" -i ${HEAT_CONF_DIR}/heat.conf
    sed -e "s:%SERVICE_TENANT_NAME%:${SERVICE_TENANT_NAME}:g" -i ${HEAT_CONF_DIR}/heat.conf

    if ${@base_contains('DISTRO_FEATURES', 'sysvinit', 'true', 'false', d)}; then
        install -d ${D}${sysconfdir}/init.d

        sed 's:@suffix@:api:' < ${WORKDIR}/heat.init >${WORKDIR}/heat-api.init.sh
        install -m 0755 ${WORKDIR}/heat-api.init.sh ${D}${sysconfdir}/init.d/heat-api

        sed 's:@suffix@:api-cfn:' < ${WORKDIR}/heat.init >${WORKDIR}/heat-api-cfn.init.sh
        install -m 0755 ${WORKDIR}/heat-api-cfn.init.sh ${D}${sysconfdir}/init.d/heat-api-cfn

        sed 's:@suffix@:engine:' < ${WORKDIR}/heat.init >${WORKDIR}/heat-engine.init.sh
        install -m 0755 ${WORKDIR}/heat-engine.init.sh ${D}${sysconfdir}/init.d/heat-engine
    fi

    cp run_tests.sh ${HEAT_CONF_DIR}
}

pkg_postinst_${SRCNAME}-setup () {
    if [ "x$D" != "x" ]; then
        exit 1
    fi
    
    # This is to make sure postgres is configured and running
    if ! pidof postmaster > /dev/null; then
       /etc/init.d/postgresql-init
       /etc/init.d/postgresql start
       sleep 2
    fi
    
    mkdir /var/log/heat
    sudo -u postgres createdb heat
    heat-manage db_sync
}

inherit setuptools identity hosts update-rc.d default_configs

PACKAGES += "${SRCNAME}-tests ${SRCNAME}-templates ${SRCNAME}-common ${SRCNAME}-api ${SRCNAME}-api-cfn ${SRCNAME}-engine"
PACKAGES += "${SRCNAME}-setup"

ALLOW_EMPTY_${SRCNAME}-setup = "1"

FILES_${PN} = "${libdir}/*"

FILES_${SRCNAME}-tests = "${sysconfdir}/${SRCNAME}/run_tests.sh"

FILES_${SRCNAME}-templates = "${sysconfdir}/${SRCNAME}/templates/*"

FILES_${SRCNAME}-common = "${sysconfdir}/${SRCNAME}/* \
"

FILES_${SRCNAME}-api = "${bindir}/heat-api \
                        ${sysconfdir}/init.d/heat-api \
"
FILES_${SRCNAME}-api-cfn = "${bindir}/heat-api-cfn \
                           ${sysconfdir}/init.d/heat-api-cfn \
"

FILES_${SRCNAME}-engine = "${bindir}/heat-engine \
                           ${bindir}/* \
                           ${sysconfdir}/init.d/heat-engine \
"

DEPENDS += " \
        python-pip \
        python-pbr \
        "

RDEPENDS_${PN} += " \
        python-heatclient \
        python-sqlalchemy \
	python-amqplib \
	python-anyjson \
	python-eventlet \
	python-kombu \
	python-lxml \
	python-routes \
	python-webob \
	python-greenlet \
	python-lockfile \
	python-pastedeploy \
	python-paste \
	python-sqlalchemy-migrate \
	python-stevedore \
	python-suds \
	python-paramiko \
	python-babel \
	python-iso8601 \
	python-setuptools-git \
	python-glanceclient \
	python-keystoneclient \
	python-swiftclient \
	python-oslo.config \
        python-msgpack \
        python-pecan \
        python-amqp \
        python-singledispatch \
        python-flask \
        python-werkzeug \
        python-itsdangerous \
        python-happybase \
        python-wsme \
        python-eventlet \
        python-pymongo \
        python-thrift \
        python-simplegeneric \
        python-webtest \
        python-waitress \
        python-pyyaml \
        python-pip \
        python-pytz \
        python-pbr \
	"

RDEPENDS_${SRCNAME}-engine = "${PN} ${SRCNAME}-templates ${SRCNAME}-common postgresql postgresql-client python-psycopg2 tgt"
RDEPENDS_${SRCNAME}-api = "${SRCNAME}-engine"
RDEPENDS_${SRCNAME}-api-cfn = "${SRCNAME}-engine"
RDEPENDS_${SRCNAME}-setup = "postgresql sudo ${SRCNAME}-engine"

INITSCRIPT_PACKAGES = "${SRCNAME}-api ${SRCNAME}-api-cfn ${SRCNAME}-engine"
INITSCRIPT_NAME_${SRCNAME}-api = "${SRCNAME}-api"
INITSCRIPT_PARAMS_${SRCNAME}-api = "${OS_DEFAULT_INITSCRIPT_PARAMS}"
INITSCRIPT_NAME_${SRCNAME}-api-cfn = "${SRCNAME}-api-cfn"
INITSCRIPT_PARAMS_${SRCNAME}-api-cfn = "${OS_DEFAULT_INITSCRIPT_PARAMS}"
INITSCRIPT_NAME_${SRCNAME}-engine = "${SRCNAME}-engine"
INITSCRIPT_PARAMS_${SRCNAME}-engine = "${OS_DEFAULT_INITSCRIPT_PARAMS}"

