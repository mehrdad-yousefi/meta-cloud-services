DESCRIPTION = "Helper to test WSGI applications"
HOMEPAGE = "https://pypi.python.org/pypi/WebTest/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://README.rst;md5=7ddcdd3b8e69edc8c5ae7e6bb64f0bc5"

SRCNAME = "WebTest"

RDEPENDS_${PN} += "python-beautifulsoup4"

SRC_URI = "https://pypi.python.org/packages/source/W/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "98e8b59da3cc6c150cebca8c92b66041"
SRC_URI[sha256sum] = "3dc92ecd7604e21fc7c97578e4c43aff2a67cebdd4884a2aa804d85e85b34b55"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
