DESCRIPTION = "Oslo Messaging API"
HOMEPAGE = "https://launchpad.net/oslo"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c46f31914956e4579f9b488e71415ac8"

PR = "r0"

SRCNAME = "oslo.messaging"
SRC_URI = "git://github.com/openstack/${SRCNAME}.git"

PV = "1.6.0"
SRCREV = "68cd8cfecc12a40b61a7b8557aad7b5a4e1f1c6d"
S = "${WORKDIR}/git"

inherit setuptools

# DEPENDS_default: python-pip

DEPENDS += " \
        python-pip \
        python-pbr \
        "

# RDEPENDS_default: 
RDEPENDS_${PN} += " \
        bash \
        python-pbr \
        "
