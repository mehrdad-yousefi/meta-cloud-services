DESCRIPTION = "Bootstrap-Datepicker JavaScript library packaged for setuptools (easy_install) / pip."
HOMEPAGE = "https://pypi.python.org/pypi/XStatic-Bootstrap-Datepicker"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=717661446a83183e303f3f8e0a1ea277"

PYPI_PACKAGE = "XStatic-Bootstrap-Datepicker"

SRC_URI[md5sum] = "68375e81274159874ab5fd6d85ea405c"
SRC_URI[sha256sum] = "df33add9f5e785fa884ac4b182601af6aac9e1eeef7cfe62dbbcb0654d0f2d6e"

inherit setuptools3 pypi

DEPENDS += " \
        ${PYTHON_PN}-pip \
        "

RDEPENDS_${PN} += " \
        "
