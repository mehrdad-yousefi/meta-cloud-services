DESCRIPTION = "Angular JavaScript library packaged for setuptools"
HOMEPAGE = "https://pypi.python.org/pypi/XStatic-Angular-Bootstrap"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PYPI_PACKAGE = "XStatic-Angular-Bootstrap"

SRC_URI[md5sum] = "cb8629df48e822255d1057a2bc624cb6"
SRC_URI[sha256sum] = "be60686c9a29c74ceeadd787969c2bcbce39f15b30daa4949574aeca602f9f35"

inherit setuptools3 pypi

DEPENDS += " \
        ${PYTHON_PN}-pip \
        "

RDEPENDS_${PN} += " \
        "
