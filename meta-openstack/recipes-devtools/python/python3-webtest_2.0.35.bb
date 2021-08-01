DESCRIPTION = "Helper to test WSGI applications"
HOMEPAGE = "https://pypi.python.org/pypi/WebTest/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://README.rst;md5=e3e00192f000e33de99fd5a3cb32a8fc"

PYPI_PACKAGE = "WebTest"

RDEPENDS:${PN} += "${PYTHON_PN}-beautifulsoup4"

SRC_URI[md5sum] = "a5d027ffa0991fdf20e305c62bd37791"
SRC_URI[sha256sum] = "aac168b5b2b4f200af4e35867cf316712210e3d5db81c1cbdff38722647bb087"

RDEPENDS:${PN} += " \
	python3-html \
	python3-logging \
	python3-webob \
"

inherit setuptools3 pypi
