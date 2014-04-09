DESCRIPTION = "Highly available, distributed, eventually consistent object/blob store."
HOMEPAGE = "https://launchpad.net/swift"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

PR = "r0"
SRCNAME = "swift"

SRC_URI = "git://github.com/openstack/${SRCNAME}.git;branch=stable/havana \
           file://proxy-server.conf \
"

SRCREV="2f3526c559fe53ce904b735a81dee6de46127176"
PV="2013.2.2+git${SRCPV}"
S = "${WORKDIR}/git"

inherit setuptools hosts identity

do_install_append() {
    SWIFT_CONF_DIR=${D}${sysconfdir}/swift

    install -d ${SWIFT_CONF_DIR}

    install -m 600 ${S}/etc/swift.conf-sample ${SWIFT_CONF_DIR}/swift.conf
    install -m 600 ${WORKDIR}/proxy-server.conf ${SWIFT_CONF_DIR}/proxy-server.conf
    install -m 600 ${S}/etc/account-server.conf-sample ${SWIFT_CONF_DIR}/account-server.conf
    install -m 600 ${S}/etc/container-server.conf-sample ${SWIFT_CONF_DIR}/container-server.conf
    install -m 600 ${S}/etc/object-server.conf-sample ${SWIFT_CONF_DIR}/object-server.conf

    sed 's/^# bind_port =.*/bind_port = 6002/' -i ${SWIFT_CONF_DIR}/account-server.conf
    sed 's/^# user =.*/user = root/' -i ${SWIFT_CONF_DIR}/account-server.conf
    sed 's/^# swift_dir =.*/swift_dir = \/etc\/swift/' -i ${SWIFT_CONF_DIR}/account-server.conf
    sed 's/^# devices =.*/devices = \/etc\/swift\/node/' -i ${SWIFT_CONF_DIR}/account-server.conf
    sed 's/^# mount_check =.*/mount_check = false/' -i ${SWIFT_CONF_DIR}/account-server.conf

    sed 's/^# bind_port =.*/bind_port = 6001/' -i ${SWIFT_CONF_DIR}/container-server.conf
    sed 's/^# user =.*/user = root/' -i ${SWIFT_CONF_DIR}/container-server.conf
    sed 's/^# swift_dir =.*/swift_dir = \/etc\/swift/' -i ${SWIFT_CONF_DIR}/container-server.conf
    sed 's/^# devices =.*/devices = \/etc\/swift\/node/' -i ${SWIFT_CONF_DIR}/container-server.conf
    sed 's/^# mount_check =.*/mount_check = false/' -i ${SWIFT_CONF_DIR}/container-server.conf

    sed 's/^# bind_port =.*/bind_port = 6000/' -i ${SWIFT_CONF_DIR}/object-server.conf
    sed 's/^# user =.*/user = root/' -i ${SWIFT_CONF_DIR}/object-server.conf
    sed 's/^# swift_dir =.*/swift_dir = \/etc\/swift/' -i ${SWIFT_CONF_DIR}/object-server.conf
    sed 's/^# devices =.*/devices = \/etc\/swift\/node/' -i ${SWIFT_CONF_DIR}/object-server.conf
    sed 's/^# mount_check =.*/mount_check = false/' -i ${SWIFT_CONF_DIR}/object-server.conf

    sed "s/%SERVICE_TENANT_NAME%/${SERVICE_TENANT_NAME}/g" -i ${SWIFT_CONF_DIR}/proxy-server.conf
    sed "s/%SERVICE_USER%/${SRCNAME}/g" -i ${SWIFT_CONF_DIR}/proxy-server.conf
    sed "s/%SERVICE_PASSWORD%/${SERVICE_PASSWORD}/g" -i ${SWIFT_CONF_DIR}/proxy-server.conf
}

PACKAGES += "${SRCNAME}"

FILES_${PN} = "${libdir}/*\
"

FILES_${SRCNAME} = "${bindir}/* \
    ${sysconfdir}/${SRCNAME}/* \
"

DEPENDS += " \
        python-pip \
        python-pbr \
        "

RDEPENDS_${PN} += " \
    python-eventlet \
    python-greenlet \
    python-pastedeploy \
    python-simplejson \
    python-swiftclient \
    python-netifaces \
    python-xattr \
    python-pbr \
    python-dnspython \
    "

RDEPENDS_${SRCNAME} = "${PN}"
