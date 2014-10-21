DESCRIPTION = "API for Linux kernel SCSI target (aka LIO)"
HOMEPAGE = "http://github.com/agrover/rtslib-fb"
SECTION = "devel/python"
LICENSE = "Apache-2"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=d137b5d839a18895dc0928806ef43548"

PR = "r0"

SRCNAME = "rtslib-fb"
SRC_URI = "http://pypi.python.org/packages/source/r/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "3dac896f1a8a8f71d3c83ffb087d845b"
SRC_URI[sha256sum] = "2239a0421518e2a3df80ad801d70a5d55340199f956abbcb6d6bbfc4dbee59da"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

# DEPENDS_default: python-pip

DEPENDS += " \
        python-pip \
        "

# RDEPENDS_default: 
RDEPENDS_${PN} += " \
        "
