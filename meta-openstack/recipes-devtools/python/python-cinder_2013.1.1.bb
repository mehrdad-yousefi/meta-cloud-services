DESCRIPTION = "OpenStack Block storage service"
HOMEPAGE = "https://launchpad.net/cinder"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

PR = "r0"
SRCNAME = "cinder"

SRC_URI = "https://launchpad.net/${SRCNAME}/grizzly/${PV}/+download/${SRCNAME}-${PV}.tar.gz \
    file://cinder.conf \
	file://api-paste.ini \
    file://cinder.init \
	"

SRC_URI[md5sum] = "8fbfbd8aad5f1a6d5e2a239b7801966d"
SRC_URI[sha256sum] = "c4d7f508f404b555242abc638901a39b02d4345c2d101a0aaad52fec1143ec2a"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools update-rc.d

do_install_append() {
	CINDER_CONF_DIR=${D}${sysconfdir}/cinder

    install -d ${CINDER_CONF_DIR}

    install -m 600 ${WORKDIR}/cinder.conf ${CINDER_CONF_DIR}/
    install -m 600 ${WORKDIR}/api-paste.ini ${CINDER_CONF_DIR}/
    install -m 600 ${S}/etc/cinder/policy.json ${CINDER_CONF_DIR}/
    
    if ${@base_contains('DISTRO_FEATURES', 'sysvinit', 'true', 'false', d)}; then
        install -d ${D}${sysconfdir}/init.d
        sed 's:@suffix@:api:' < ${WORKDIR}/cinder.init >${WORKDIR}/cinder-api.init.sh
        install -m 0755 ${WORKDIR}/cinder-api.init.sh ${D}${sysconfdir}/init.d/cinder-api
        sed 's:@suffix@:volume:' < ${WORKDIR}/cinder.init >${WORKDIR}/cinder-volume.init.sh
        install -m 0755 ${WORKDIR}/cinder-volume.init.sh ${D}${sysconfdir}/init.d/cinder-volume
    fi
}

pkg_postinst_${SRCNAME} () {
    if [ "x$D" != "x" ]; then
        exit 1
    fi

    # quick fix
    /etc/rpm-postinsts/postgresql

    sudo -u postgres createdb cinder
    cinder-manage db sync
    echo "include /etc/cinder/data/volumes/*" >> /etc/tgt/targets.conf
}

PACKAGES += "${SRCNAME} ${SRCNAME}-api ${SRCNAME}-volume"

FILES_${PN} = "${libdir}/*"

FILES_${SRCNAME}-api = "${bindir}/cinder-api \
    ${sysconfdir}/init.d/cinder-api"

FILES_${SRCNAME}-volume = "${bindir}/cinder-volume \
    ${sysconfdir}/init.d/cinder-volume"

FILES_${SRCNAME} = "${bindir}/* \
    ${sysconfdir}/${SRCNAME}/* "

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

INITSCRIPT_PACKAGES = "${SRCNAME}-api ${SRCNAME}-volume"
INITSCRIPT_NAME_${SRCNAME}-api = "cinder-api"
INITSCRIPT_NAME_${SRCNAME}-volume = "cinder-volume"
