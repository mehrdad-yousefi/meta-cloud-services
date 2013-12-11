DESCRIPTION = "OpenStack Block storage service"
HOMEPAGE = "https://launchpad.net/cinder"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

PR = "r0"
SRCNAME = "cinder"

SRC_URI = "git://github.com/openstack/${SRCNAME}.git;branch=stable/havana \
    file://cinder.conf \
    file://cinder.init \
    file://cinder-volume \
    file://0001-run_tests-respect-tools-dir.patch \
	"

SRCREV="1f99a044580286bf0d927cc7fc7ce3378653aef0"
PV="2013.2+git${SRCPV}"
S = "${WORKDIR}/git"

inherit setuptools update-rc.d identity

do_install_append() {
    TEMPLATE_CONF_DIR=${S}${sysconfdir}/${SRCNAME}
    CINDER_CONF_DIR=${D}${sysconfdir}/${SRCNAME}

    sed -e "s:%SERVICE_TENANT_NAME%:${SERVICE_TENANT_NAME}:g" \
        ${TEMPLATE_CONF_DIR}/api-paste.ini > ${WORKDIR}/api-paste.ini
    sed -e "s:%SERVICE_USER%:${SRCNAME}:g" -i ${WORKDIR}/api-paste.ini
    sed -e "s:%SERVICE_PASSWORD%:${SERVICE_PASSWORD}:g" \
        -i ${WORKDIR}/api-paste.ini

    sed -e "s:%DB_USER%:${DB_USER}:g" -i ${WORKDIR}/cinder.conf
    sed -e "s:%DB_PASSWORD%:${DB_PASSWORD}:g" -i ${WORKDIR}/cinder.conf

    install -d ${CINDER_CONF_DIR}
    install -m 600 ${WORKDIR}/cinder.conf ${CINDER_CONF_DIR}/
    install -m 600 ${WORKDIR}/api-paste.ini ${CINDER_CONF_DIR}/
    install -m 600 ${S}/etc/cinder/policy.json ${CINDER_CONF_DIR}/

    install -d ${D}${localstatedir}/log/${SRCNAME}

    if ${@base_contains('DISTRO_FEATURES', 'sysvinit', 'true', 'false', d)}; then
        install -d ${D}${sysconfdir}/init.d
        sed 's:@suffix@:api:' < ${WORKDIR}/cinder.init >${WORKDIR}/cinder-api.init.sh
        install -m 0755 ${WORKDIR}/cinder-api.init.sh ${D}${sysconfdir}/init.d/cinder-api
        sed 's:@suffix@:scheduler:' < ${WORKDIR}/cinder.init >${WORKDIR}/cinder-scheduler.init.sh
        install -m 0755 ${WORKDIR}/cinder-scheduler.init.sh ${D}${sysconfdir}/init.d/cinder-scheduler
        install -m 0755 ${WORKDIR}/cinder-volume ${D}${sysconfdir}/init.d/cinder-volume
    fi

    # test setup
    cp run_tests.sh ${CINDER_CONF_DIR}
    cp -r tools ${CINDER_CONF_DIR}
}

pkg_postinst_${SRCNAME}-setup () {
    if [ "x$D" != "x" ]; then
        exit 1
    fi

    # This is to make sure postgres is configured and running
    if ! pidof postmaster > /dev/null; then
       /etc/init.d/postgresql-init
       /etc/init.d/postgresql start
    fi

    sudo -u postgres createdb cinder
    cinder-manage db sync

    #Create cinder volume group backing file
    [[ -f /etc/cinder/volumes-backing ]] || truncate -s 2G /etc/cinder/volumes-backing
    echo "include /etc/cinder/data/volumes/*" >> /etc/tgt/targets.conf
}

PACKAGES += "${SRCNAME}-tests ${SRCNAME} ${SRCNAME}-setup ${SRCNAME}-api ${SRCNAME}-volume ${SRCNAME}-scheduler"
ALLOW_EMPTY_${SRCNAME}-setup = "1"

FILES_${PN} = "${libdir}/*"

FILES_${SRCNAME}-tests = "${sysconfdir}/${SRCNAME}/run_tests.sh \
                          ${sysconfdir}/${SRCNAME}/tools"

FILES_${SRCNAME}-api = "${bindir}/cinder-api \
    ${sysconfdir}/init.d/cinder-api"

FILES_${SRCNAME}-volume = "${bindir}/cinder-volume \
    ${sysconfdir}/init.d/cinder-volume"

FILES_${SRCNAME}-scheduler = "${bindir}/cinder-scheduler \
    ${sysconfdir}/init.d/cinder-scheduler"

FILES_${SRCNAME} = "${bindir}/* \
    ${sysconfdir}/${SRCNAME}/* \
    ${localstatedir}/* \
    "

RDEPENDS_${PN} += "lvm2 \
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
	"

RDEPENDS_${SRCNAME} = "${PN} \
        postgresql postgresql-client python-psycopg2 tgt"

RDEPENDS_${SRCNAME}-api = "${SRCNAME}"
RDEPENDS_${SRCNAME}-volume = "${SRCNAME}"
RDEPENDS_${SRCNAME}-scheduler = "${SRCNAME}"

INITSCRIPT_PACKAGES = "${SRCNAME}-api ${SRCNAME}-volume ${SRCNAME}-scheduler"
INITSCRIPT_NAME_${SRCNAME}-api = "cinder-api"
INITSCRIPT_NAME_${SRCNAME}-volume = "cinder-volume"
INITSCRIPT_NAME_${SRCNAME}-scheduler = "cinder-scheduler"
