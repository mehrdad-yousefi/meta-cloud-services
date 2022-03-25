DESCRIPTION = "API for Linux kernel SCSI target (aka LIO)"
HOMEPAGE = "http://github.com/agrover/rtslib-fb"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=cf391b108961d84a581f45259ec47c52"

SRC_URI[md5sum] = "85ab011e3a98fb585d8a0fb337c5dab4"
SRC_URI[sha256sum] = "6f15bc30b55e0d35f29edde4f35880965b2f1e9acee1424e6e9820f32b0a925c"

inherit setuptools3 pypi

# DEPENDS_default: python-pip

DEPENDS += " \
        ${PYTHON_PN}-pip \
        "

# RDEPENDS:default: 
RDEPENDS:${PN} += " \
        ${PYTHON_PN}-json \
        ${PYTHON_PN}-shell \
        ${PYTHON_PN}-six \
        ${PYTHON_PN}-pyudev \
        ${PYTHON_PN}-resource \
        "
