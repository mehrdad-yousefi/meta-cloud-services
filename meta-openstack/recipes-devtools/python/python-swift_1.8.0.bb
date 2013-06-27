DESCRIPTION = "Highly available, distributed, eventually consistent object/blob store."
HOMEPAGE = "https://launchpad.net/swift"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

PR = "r0"
SRCNAME = "swift"

SRC_URI = "https://launchpad.net/${SRCNAME}/grizzly/${PV}/+download/${SRCNAME}-${PV}.tar.gz \
"

SRC_URI[md5sum] = "0d2479c3cbb124fa3a6b001d0d4d5a8b"
SRC_URI[sha256sum] = "613185473e0c6f11c77bdc6b65efee195303268117afd9024fee82ebde6ed8a3"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

do_install_append() {
    SWIFT_CONF_DIR=${D}${sysconfdir}/swift

    install -d ${SWIFT_CONF_DIR}

    install -m 600 ${S}/etc/swift.conf-sample ${SWIFT_CONF_DIR}/swift.conf
    install -m 600 ${S}/etc/proxy-server.conf-sample ${SWIFT_CONF_DIR}/proxy-server.conf
    install -m 600 ${S}/etc/account-server.conf-sample ${SWIFT_CONF_DIR}/account-server.conf
    install -m 600 ${S}/etc/container-server.conf-sample ${SWIFT_CONF_DIR}/container-server.conf
    install -m 600 ${S}/etc/object-server.conf-sample ${SWIFT_CONF_DIR}/object-server.conf
}

PACKAGES += "${SRCNAME}"

FILES_${PN} = "${libdir}/*\
"

FILES_${SRCNAME} = "${bindir}/* \
    ${sysconfdir}/${SRCNAME}/* \
"

RDEPENDS_${PN} += " \
    python-eventlet \
    python-greenlet \
    python-pastedeploy \
    python-simplejson \
    python-swiftclient \
    python-netifaces \
    python-xattr \
    "

RDEPENDS_${SRCNAME} = "${PN}"