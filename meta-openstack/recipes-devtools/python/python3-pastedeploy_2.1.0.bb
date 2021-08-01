DESCRIPTION = "Load, configure, and compose WSGI applications and servers"
HOMEPAGE = "http://pythonpaste.org/deploy/"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=57609488f8ad28ebf6844a5169a85215"

PYPI_PACKAGE = "PasteDeploy"

SRC_URI[md5sum] = "f1e62dc76092433b7ae150cd81603fbd"
SRC_URI[sha256sum] = "e7559878b6e92023041484be9bcb6d767cf4492fc3de7257a5dae76a7cc11a9b"

inherit setuptools3 pypi

DEPENDS += "${PYTHON_PN}-pytest-runner-native"

RDEPENDS:${PN} += " \
	${PYTHON_PN}-paste \
	${PYTHON_PN}-setuptools \
"
