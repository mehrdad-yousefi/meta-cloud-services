DESCRIPTION = "OpenStack Orchestration"
HOMEPAGE = "https://launchpad.net/heat"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

SRCNAME = "heat"

SRC_URI = "git://github.com/openstack/${SRCNAME}.git;branch=master;protocol=https \
           file://heat.conf \
           file://heat.init \
           file://autoscaling_example.template \
           file://one_vm_example.template \
           file://two_vms_example.template \
           file://heat-tests-change-project_dir-path.patch \
"

SRCREV = "4348b7ababd1048e17ec354ca38c903c908cd74e"
PV = "5.0.0+git${SRCPV}"
S = "${WORKDIR}/git"

SERVICECREATE_PACKAGES = "${SRCNAME}-setup ${SRCNAME}-templates ${SRCNAME}-cfn"
KEYSTONE_HOST="${CONTROLLER_IP}"

# USERCREATE_PARAM and SERVICECREATE_PARAM contain the list of parameters to be set.
# If the flag for a parameter in the list is not set here, the default value will be given to that parameter.
# Parameters not in the list will be set to empty.

USERCREATE_PARAM_${SRCNAME}-setup = "name pass tenant role email"
SERVICECREATE_PARAM_${SRCNAME}-setup = "name type description region publicurl adminurl internalurl"
python () {
    flags = {'type':'orchestration',\
             'description':'OpenStack Orchestration Service',\
             'publicurl':"'http://${KEYSTONE_HOST}:8004/v1/\$(tenant_id)s'",\
             'adminurl':"'http://${KEYSTONE_HOST}:8004/v1/\$(tenant_id)s'",\
             'internalurl':"'http://${KEYSTONE_HOST}:8004/v1/\$(tenant_id)s'"}

    d.setVarFlags("SERVICECREATE_PARAM_%s-setup" % d.getVar('SRCNAME',True), flags)
}

# heat stack template user role
USERCREATE_PARAM_${SRCNAME}-templates = "role"
python () {
    flags = {'role':'heat_stack_user'}
    d.setVarFlags("USERCREATE_PARAM_%s-templates" % d.getVar('SRCNAME',True), flags)
}

# api-cfn service
SERVICECREATE_PARAM_${SRCNAME}-cfn = "name type description region publicurl adminurl internalurl"
python () {
    flags = {'name':'heat-cfn',\
             'type':'cloudformation',\
             'description':'OpenStack Cloudformation Service',\
             'publicurl':"'http://${KEYSTONE_HOST}:8000/v1'",\
             'adminurl':"'http://${KEYSTONE_HOST}:8000/v1'",\
             'internalurl':"'http://${KEYSTONE_HOST}:8000/v1'"}
    d.setVarFlags("SERVICECREATE_PARAM_%s-cfn" % d.getVar('SRCNAME',True), flags)
}

do_install:append() {
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

    if ${@bb.utils.contains('DISTRO_FEATURES', 'sysvinit', 'true', 'false', d)}; then
        install -d ${D}${sysconfdir}/init.d

        sed 's:@suffix@:api:' < ${WORKDIR}/heat.init >${WORKDIR}/heat-api.init.sh
        install -m 0755 ${WORKDIR}/heat-api.init.sh ${D}${sysconfdir}/init.d/heat-api

        sed 's:@suffix@:api-cfn:' < ${WORKDIR}/heat.init >${WORKDIR}/heat-api-cfn.init.sh
        install -m 0755 ${WORKDIR}/heat-api-cfn.init.sh ${D}${sysconfdir}/init.d/heat-api-cfn

        sed 's:@suffix@:engine:' < ${WORKDIR}/heat.init >${WORKDIR}/heat-engine.init.sh
        install -m 0755 ${WORKDIR}/heat-engine.init.sh ${D}${sysconfdir}/init.d/heat-engine
    fi

    if [ -e "run_tests.sh" ]; then
        cp run_tests.sh ${HEAT_CONF_DIR}
    fi
}

pkg_postinst:${SRCNAME}-setup () {
    if [ -z "$D" ]; then
	# This is to make sure postgres is configured and running
	if ! pidof postmaster > /dev/null; then
	   /etc/init.d/postgresql-init
	   /etc/init.d/postgresql start
	   sleep 2
	fi

	mkdir /var/log/heat
	sudo -u postgres createdb heat
	heat-manage db_sync
    fi
}

inherit setuptools3 identity hosts update-rc.d default_configs monitor

PACKAGES += "${SRCNAME}-tests ${SRCNAME}-templates ${SRCNAME}-common ${SRCNAME}-api ${SRCNAME}-api-cfn ${SRCNAME}-engine"
PACKAGES += "${SRCNAME}-setup"
PACKAGES += "${SRCNAME}-cfn"

RDEPENDS:${SRCNAME}-tests += " bash"

ALLOW_EMPTY:${SRCNAME}-tests = "1"
ALLOW_EMPTY:${SRCNAME}-setup = "1"
ALLOW_EMPTY:${SRCNAME}-templates = "1"
ALLOW_EMPTY:${SRCNAME}-cfn = "1"

FILES:${PN} = "${libdir}/*"

FILES:${SRCNAME}-tests = "${sysconfdir}/${SRCNAME}/run_tests.sh"

FILES:${SRCNAME}-templates = "${sysconfdir}/${SRCNAME}/templates/*"

FILES:${SRCNAME}-common = "${sysconfdir}/${SRCNAME}/* \
"

FILES:${SRCNAME}-api = "${bindir}/heat-api \
                        ${sysconfdir}/init.d/heat-api \
"
FILES:${SRCNAME}-api-cfn = "${bindir}/heat-api-cfn \
                           ${sysconfdir}/init.d/heat-api-cfn \
"

FILES:${SRCNAME}-engine = "${bindir}/heat-engine \
                           ${bindir}/* \
                           ${sysconfdir}/init.d/heat-engine \
"

DEPENDS += " \
        python3-pip \
        python3-pbr \
        "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python3-pbr-native \
        "

RDEPENDS:${PN} += " \
        python-heatclient \
        python3-sqlalchemy \
	python3-amqplib \
	python3-eventlet \
	python3-kombu \
	python3-lxml \
	python3-routes \
	python3-webob \
	python3-greenlet \
	python3-lockfile \
	python3-pastedeploy \
	python3-paste \
	python3-sqlalchemy-migrate \
	python3-stevedore \
	python3-suds-jurko \
	python3-paramiko \
	python3-babel \
	python3-iso8601 \
	python3-setuptools-git \
	python-glanceclient \
	python3-keystoneclient \
	python3-swiftclient \
	python3-oslo.config \
        python3-msgpack \
        python3-pecan \
        python3-amqp \
        python3-singledispatch \
        python3-flask \
        python3-werkzeug \
        python3-itsdangerous \
        python3-happybase \
        python3-wsme \
        python3-eventlet \
        python3-pymongo \
        python3-thrift \
        python3-simplegeneric \
        python3-webtest \
        python3-waitress \
        python3-pyyaml \
        python3-pip \
        python3-pytz \
        python3-pbr \
        python3-oslo.log \
        python3-croniter \
        python3-cryptography \
        python3-keystonemiddleware \
        python3-netaddr \
        python3-oslo.cache \
        python3-oslo.concurrency \
        python3-oslo.context \
        python3-oslo.db \
        python3-oslo.i18n \
        python3-oslo.messaging \
        python3-oslo.middleware \
        python3-oslo.policy \
        python3-oslo.reports \
        python3-oslo.serialization \
        python3-oslo.service \
        python3-oslo.utils \
        python3-osprofiler \
        python3-oslo.versionedobjects \
        python3-pycrypto \
        python3-barbicanclient \
        python-cinderclient \
        python3-designateclient \
        python3-magnumclient \
        python3-manilaclient \
        python3-mistralclient \
        python-neutronclient \
        python-novaclient \
        python3-saharaclient \
        python-troveclient \
        python3-zaqarclient \
        python3-requests \
        python3-six \
        bash \
	"

RDEPENDS:${SRCNAME}-engine = "${PN} ${SRCNAME}-templates ${SRCNAME}-common postgresql postgresql-client python-psycopg2 tgt ${SRCNAME}-cfn bash"
RDEPENDS:${SRCNAME}-api = "${SRCNAME}-engine"
RDEPENDS:${SRCNAME}-api-cfn = "${SRCNAME}-engine"
RDEPENDS:${SRCNAME}-setup = "postgresql sudo ${SRCNAME}-engine"
RDEPENDS:${SRCNAME}-templates = "postgresql sudo"
RDEPENDS:${SRCNAME}-cfn = "postgresql sudo"

INITSCRIPT_PACKAGES = "${SRCNAME}-api ${SRCNAME}-api-cfn ${SRCNAME}-engine"
INITSCRIPT_NAME:${SRCNAME}-api = "${SRCNAME}-api"
INITSCRIPT_PARAMS:${SRCNAME}-api = "${OS_DEFAULT_INITSCRIPT_PARAMS}"
INITSCRIPT_NAME:${SRCNAME}-api-cfn = "${SRCNAME}-api-cfn"
INITSCRIPT_PARAMS:${SRCNAME}-api-cfn = "${OS_DEFAULT_INITSCRIPT_PARAMS}"
INITSCRIPT_NAME:${SRCNAME}-engine = "${SRCNAME}-engine"
INITSCRIPT_PARAMS:${SRCNAME}-engine = "${OS_DEFAULT_INITSCRIPT_PARAMS}"

MONITOR_SERVICE_PACKAGES = "${SRCNAME}"
MONITOR_SERVICE_${SRCNAME} = "heat"
