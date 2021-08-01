DESCRIPTION = "Angular-Gettext javascript library packaged for setuptools (easy_install) / pip."
HOMEPAGE = "https://pypi.python.org/pypi/XStatic-Angular-Gettext"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PYPI_PACKAGE = "XStatic-Angular-Gettext"

SRC_URI[md5sum] = "6552973138d37609c776d2d8a049aabe"
SRC_URI[sha256sum] = "883192c9273b2d1b8dc69e605845f0d3a267698955e55dcde0e3a4defeae385b"

inherit setuptools3 pypi

DEPENDS += " \
        ${PYTHON_PN}-pip \
        "

RDEPENDS:${PN} += " \
        "
