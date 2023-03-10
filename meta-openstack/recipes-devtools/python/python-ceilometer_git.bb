DESCRIPTION = "OpenStack Metering Component"
HOMEPAGE = "https://launchpad.net/ceilometer"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

SRCNAME = "ceilometer"

SRC_URI = "git://github.com/openstack/${SRCNAME}.git;branch=master;protocol=https \
           file://ceilometer.conf \
           file://ceilometer.init \
"
# dropped for juno:
#   file://ceilometer-builtin-tests-config-location.patch


SRCREV = "6f88ee6be9a3ae5c78587f1a2bc8cd2e9a5a2fa7"
PV = "19.0.0+git${SRCPV}"
S = "${WORKDIR}/git"

CEILOMETER_SECRET ?= "12121212"

SERVICECREATE_PACKAGES = "${SRCNAME}-setup ${SRCNAME}-reseller"
KEYSTONE_HOST="${CONTROLLER_IP}"

# USERCREATE_PARAM and SERVICECREATE_PARAM contain the list of parameters to be set.
# If the flag for a parameter in the list is not set here, the default value will be given to that parameter.
# Parameters not in the list will be set to empty.

USERCREATE_PARAM_${SRCNAME}-setup = "name pass tenant role email"
SERVICECREATE_PARAM_${SRCNAME}-setup = "name type description region publicurl adminurl internalurl"
python () {
    flags = {'type':'metering',\
             'description':'OpenStack Metering Service',\
             'publicurl':"'http://${KEYSTONE_HOST}:8777/'",\
             'adminurl':"'http://${KEYSTONE_HOST}:8777/'",\
             'internalurl':"'http://${KEYSTONE_HOST}:8777/'"}

    d.setVarFlags("SERVICECREATE_PARAM_%s-setup" % d.getVar('SRCNAME',True), flags)
}

# Add service user to service tenant as ResellerAdmin role
USERCREATE_PARAM_${SRCNAME}-reseller = "name pass tenant role email"
python () {
    flags = {'role':'ResellerAdmin'}
    d.setVarFlags("USERCREATE_PARAM_%s-reseller" % d.getVar('SRCNAME',True), flags)
}

do_configure:append() {
    # We are using postgresql support, hence this requirement is not valid
    # removing it, to avoid on-target runtime issues
    sed -e "s:MySQL-python::g" -i ${S}/requirements.txt
}

do_install:append() {
    TEMPLATE_CONF_DIR=${S}${sysconfdir}/${SRCNAME}
    CEILOMETER_CONF_DIR=${D}${sysconfdir}/${SRCNAME}

    install -d ${CEILOMETER_CONF_DIR}
    install -m 600 ${WORKDIR}/ceilometer.conf ${CEILOMETER_CONF_DIR}
    install -m 600 ${TEMPLATE_CONF_DIR}/*.yaml ${CEILOMETER_CONF_DIR}

    sed -e "s:%CEILOMETER_SECRET%:${CEILOMETER_SECRET}:g" -i ${CEILOMETER_CONF_DIR}/ceilometer.conf

    sed -e "s:%DB_USER%:${DB_USER}:g" -i ${CEILOMETER_CONF_DIR}/ceilometer.conf
    sed -e "s:%DB_PASSWORD%:${DB_PASSWORD}:g" -i ${CEILOMETER_CONF_DIR}/ceilometer.conf

    sed -e "s:%CONTROLLER_IP%:${CONTROLLER_IP}:g" -i ${CEILOMETER_CONF_DIR}/ceilometer.conf
    sed -e "s:%CONTROLLER_HOST%:${CONTROLLER_HOST}:g" -i ${CEILOMETER_CONF_DIR}/ceilometer.conf

    sed -e "s:%COMPUTE_IP%:${COMPUTE_IP}:g" -i ${CEILOMETER_CONF_DIR}/ceilometer.conf
    sed -e "s:%COMPUTE_HOST%:${COMPUTE_HOST}:g" -i ${CEILOMETER_CONF_DIR}/ceilometer.conf

    sed -e "s:%ADMIN_PASSWORD%:${ADMIN_PASSWORD}:g" -i ${CEILOMETER_CONF_DIR}/ceilometer.conf
    sed -e "s:%SERVICE_TENANT_NAME%:${SERVICE_TENANT_NAME}:g" -i ${CEILOMETER_CONF_DIR}/ceilometer.conf

    install -d ${D}${sysconfdir}/init.d

    sed 's:@suffix@:api:' < ${WORKDIR}/ceilometer.init >${WORKDIR}/ceilometer-api.init.sh
    install -m 0755 ${WORKDIR}/ceilometer-api.init.sh ${D}${sysconfdir}/init.d/ceilometer-api

    sed 's:@suffix@:collector:' < ${WORKDIR}/ceilometer.init >${WORKDIR}/ceilometer-collector.init.sh
    install -m 0755 ${WORKDIR}/ceilometer-collector.init.sh ${D}${sysconfdir}/init.d/ceilometer-collector

    sed 's:@suffix@:agent-central:' < ${WORKDIR}/ceilometer.init >${WORKDIR}/ceilometer-agent-central.init.sh
    install -m 0755 ${WORKDIR}/ceilometer-agent-central.init.sh ${D}${sysconfdir}/init.d/ceilometer-agent-central

    sed 's:@suffix@:agent-compute:' < ${WORKDIR}/ceilometer.init >${WORKDIR}/ceilometer-agent-compute.init.sh
    install -m 0755 ${WORKDIR}/ceilometer-agent-compute.init.sh ${D}${sysconfdir}/init.d/ceilometer-agent-compute

    sed 's:@suffix@:alarm-notifier:' < ${WORKDIR}/ceilometer.init >${WORKDIR}/ceilometer-alarm-notifier.init.sh
    install -m 0755 ${WORKDIR}/ceilometer-alarm-notifier.init.sh ${D}${sysconfdir}/init.d/ceilometer-alarm-notifier

    sed 's:@suffix@:alarm-evaluator:' < ${WORKDIR}/ceilometer.init >${WORKDIR}/ceilometer-alarm-evaluator.init.sh
    install -m 0755 ${WORKDIR}/ceilometer-alarm-evaluator.init.sh ${D}${sysconfdir}/init.d/ceilometer-alarm-evaluator

    sed 's:@suffix@:agent-notification:' < ${WORKDIR}/ceilometer.init >${WORKDIR}/ceilometer-agent-notification.init.sh
    install -m 0755 ${WORKDIR}/ceilometer-agent-notification.init.sh ${D}${sysconfdir}/init.d/ceilometer-agent-notification

    if [ -e "setup-test-env.sh" ]; then
        cp setup-test-env.sh ${CEILOMETER_CONF_DIR}
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

        mkdir /var/log/ceilometer
        sudo -u postgres createdb ceilometer
        ceilometer-dbsync
    fi
}

inherit setuptools3 identity hosts update-rc.d default_configs monitor

PACKAGES += " ${SRCNAME}-tests"
PACKAGES += "${SRCNAME}-setup ${SRCNAME}-common ${SRCNAME}-api"
PACKAGES += "${SRCNAME}-alarm-notifier ${SRCNAME}-alarm-evaluator"
PACKAGES += "${SRCNAME}-agent-notification"
PACKAGES += "${SRCNAME}-collector ${SRCNAME}-compute ${SRCNAME}-controller"
PACKAGES += " ${SRCNAME}-reseller"

RDEPENDS:${SRCNAME}-tests += " bash"

ALLOW_EMPTY:${SRCNAME}-setup = "1"
ALLOW_EMPTY:${SRCNAME}-reseller = "1"
ALLOW_EMPTY:${SRCNAME}-tests = "1"

FILES:${PN} = "${libdir}/* \
               /usr/etc/ceilometer/** \
              "

FILES:${SRCNAME}-tests = "${sysconfdir}/${SRCNAME}/setup-test-env.sh"

FILES:${SRCNAME}-common = "${sysconfdir}/${SRCNAME}/* \
"

FILES:${SRCNAME}-api = "${bindir}/ceilometer-api \
                        ${sysconfdir}/init.d/ceilometer-api \
"

FILES:${SRCNAME}-collector = "${bindir}/ceilometer-collector \
                              ${bindir}/ceilometer-collector-udp \
                              ${sysconfdir}/init.d/ceilometer-collector \
"
FILES:${SRCNAME}-alarm-evaluator = "${bindir}/ceilometer-alarm-evaluator \
                                    ${sysconfdir}/init.d/ceilometer-alarm-evaluator \
"

FILES:${SRCNAME}-alarm-notifier = "${bindir}/ceilometer-alarm-notifier \
                                   ${sysconfdir}/init.d/ceilometer-alarm-notifier \
"

FILES:${SRCNAME}-agent-notification = "${bindir}/ceilometer-agent-notification \
                                       ${sysconfdir}/init.d/ceilometer-agent-notification \
"

FILES:${SRCNAME}-compute = "${bindir}/ceilometer-agent-compute \
                            ${sysconfdir}/init.d/ceilometer-agent-compute \
"

FILES:${SRCNAME}-controller = "${bindir}/* \
                               ${localstatedir}/* \
                               ${sysconfdir}/init.d/ceilometer-agent-central \
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
	python3-ply \
	python3-jsonpath-rw \
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
	python3-suds \
	python3-paramiko \
	python3-babel \
	python3-iso8601 \
	python3-setuptools-git \
	python-glanceclient \
	python3-keystoneclient \
	python3-swiftclient \
	python3-oslo.config \
	python3-oslo.serialization \
	python3-oslo.rootwrap \
	python3-tooz \        
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
	python3-croniter \
	python3-pysnmp \
        python3-retrying \
        python3-jsonpath-rw-ext \
        python3-jsonschema \
        python3-kafka \
        python3-keystonemiddleware \
        python3-oslo.context \
        python3-oslo.db \
        python3-oslo.concurrency \
        python3-oslo.i18n \
        python3-oslo.log \
        python3-oslo.policy \
        python3-oslo.reports \
        python3-oslo.service \
        python3-oslo.messaging \
        python3-oslo.middleware \
        python3-oslo.utils \
        python-neutronclient \
        python-novaclient \
        python3-requests \
        python3-six \
        python3-tooz \
        bash \
	"

RDEPENDS:${SRCNAME}-controller = "${PN} ${SRCNAME}-common ${SRCNAME}-alarm-notifier ${SRCNAME}-alarm-evaluator ${SRCNAME}-agent-notification ${SRCNAME}-reseller \
                                  postgresql postgresql-client python-psycopg2 tgt"
RDEPENDS:${SRCNAME}-api = "${SRCNAME}-controller"
RDEPENDS:${SRCNAME}-collector = "${SRCNAME}-controller"
RDEPENDS:${SRCNAME}-compute = "${PN} ${SRCNAME}-common libvirt"
RDEPENDS:${SRCNAME}-setup = "postgresql sudo ${SRCNAME}-controller"
RDEPENDS:${SRCNAME}-reseller = "postgresql sudo ${SRCNAME}-controller"

INITSCRIPT_PACKAGES =  "${SRCNAME}-api ${SRCNAME}-collector ${SRCNAME}-compute ${SRCNAME}-controller"
INITSCRIPT_PACKAGES += "${SRCNAME}-alarm-notifier ${SRCNAME}-alarm-evaluator ${SRCNAME}-agent-notification"
INITSCRIPT_NAME:${SRCNAME}-api = "${SRCNAME}-api"
INITSCRIPT_PARAMS:${SRCNAME}-api = "${OS_DEFAULT_INITSCRIPT_PARAMS}"
INITSCRIPT_NAME:${SRCNAME}-collector = "${SRCNAME}-collector"
INITSCRIPT_PARAMS:${SRCNAME}-collector = "${OS_DEFAULT_INITSCRIPT_PARAMS}"
INITSCRIPT_NAME:${SRCNAME}-compute = "${SRCNAME}-agent-compute"
INITSCRIPT_PARAMS:${SRCNAME}-compute = "${OS_DEFAULT_INITSCRIPT_PARAMS}"
INITSCRIPT_NAME:${SRCNAME}-controller = "${SRCNAME}-agent-central"
INITSCRIPT_PARAMS:${SRCNAME}-controller = "${OS_DEFAULT_INITSCRIPT_PARAMS}"
INITSCRIPT_NAME:${SRCNAME}-alarm-notifier = "${SRCNAME}-alarm-notifier"
INITSCRIPT_PARAMS:${SRCNAME}-alarm-notifier = "${OS_DEFAULT_INITSCRIPT_PARAMS}"
INITSCRIPT_NAME:${SRCNAME}-alarm-evaluator = "${SRCNAME}-alarm-evaluator"
INITSCRIPT_PARAMS:${SRCNAME}-alarm-evaluator = "${OS_DEFAULT_INITSCRIPT_PARAMS}"
INITSCRIPT_NAME:${SRCNAME}-agent-notification = "${SRCNAME}-agent-notification"
INITSCRIPT_PARAMS:${SRCNAME}-agent-notification = "${OS_DEFAULT_INITSCRIPT_PARAMS}"

MONITOR_SERVICE_PACKAGES = "${SRCNAME}"
MONITOR_SERVICE_${SRCNAME} = "ceilometer"
