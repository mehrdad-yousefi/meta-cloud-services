DESCRIPTION = "Oslo Messaging API"
HOMEPAGE = "https://launchpad.net/oslo"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c46f31914956e4579f9b488e71415ac8"

PR = "r0"

SRCNAME = "oslo.messaging"
SRC_URI = "http://pypi.python.org/packages/source/o/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "ca7e4fe7993da5eb6b642abae1d50e3a"
SRC_URI[sha256sum] = "5abcb4c8725319e18a2d7d86f3768dfb3beb2b598cb4761879d45f509c95743c"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

# DEPENDS_default: python-pip

DEPENDS += " \
        python-pip \
        "

# RDEPENDS_default: 
RDEPENDS_${PN} += " \
        "
