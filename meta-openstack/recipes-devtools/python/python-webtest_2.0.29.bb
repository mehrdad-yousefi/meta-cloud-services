DESCRIPTION = "Helper to test WSGI applications"
HOMEPAGE = "https://pypi.python.org/pypi/WebTest/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://README.rst;md5=c7fb282fc7269ea1ef7dd689470b528b"

PYPI_PACKAGE = "WebTest"

RDEPENDS_${PN} += "python-beautifulsoup4"

SRC_URI[md5sum] = "30b4cf0d340b9a5335fac4389e6f84fc"
SRC_URI[sha256sum] = "dbbccc15ac2465066c95dc3a7de0d30cde3791e886ccbd7e91d5d2a2580c922d"

inherit setuptools pypi
