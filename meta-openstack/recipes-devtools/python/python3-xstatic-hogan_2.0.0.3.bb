DESCRIPTION = "Hogan JavaScript library packaged for setuptools"
HOMEPAGE = "https://pypi.python.org/pypi/XStatic-Hogan"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=e5366bec2bd8e901c248ef0df2425a7f"

PYPI_PACKAGE = "XStatic-Hogan"

SRC_URI[md5sum] = "b9b7610ba5c16e9ba398efb83d26a656"
SRC_URI[sha256sum] = "27a921963e470abbada15b2d85d198833795aaead5fd73339bc2883cfddb5619"

inherit setuptools3 pypi

# DEPENDS_default: python3-pip

DEPENDS += " \
        ${PYTHON_PN}-pip \
        "

# RDEPENDS:default: 
RDEPENDS:${PN} += " \
        "
