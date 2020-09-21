DESCRIPTION = "Jasmine JavaScript library packaged for setuptools "
HOMEPAGE = "https://pypi.python.org/pypi/XStatic-Jasmine"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PYPI_PACKAGE = "XStatic-Jasmine"

SRC_URI[md5sum] = "736937d16fd655d1f6f2096b97d8255b"
SRC_URI[sha256sum] = "bf921be423c254a5cebc2156a7fd66d8210cefd251fc2fa51f792a153bf9e82b"

inherit setuptools3 pypi

# DEPENDS_default: python-pip

DEPENDS += " \
        ${PYTHON_PN}-pip \
        "

# RDEPENDS_default: 
RDEPENDS_${PN} += " \
        "
