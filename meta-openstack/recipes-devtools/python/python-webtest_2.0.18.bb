DESCRIPTION = "Helper to test WSGI applications"
HOMEPAGE = "https://pypi.python.org/pypi/WebTest/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://README.rst;md5=7ddcdd3b8e69edc8c5ae7e6bb64f0bc5"

SRCNAME = "WebTest"

RDEPENDS_${PN} += "python-beautifulsoup4"

SRC_URI = "https://pypi.python.org/packages/source/W/${SRCNAME}/${SRCNAME}-${PV}.zip"

SRC_URI[md5sum] = "444a4160408670a50d7cb149a4035cf5"
SRC_URI[sha256sum] = "beb569e6d707cb4cd82c226c97b7e1f41cd62bae656d89e687107eef8376c7fd"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
