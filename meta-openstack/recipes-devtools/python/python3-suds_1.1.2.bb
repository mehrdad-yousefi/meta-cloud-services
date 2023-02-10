DESCRIPTION = "Lightweight SOAP client"
HOMEPAGE = "https://github.com/suds-community/suds"
SECTION = "devel/python"
LICENSE = "LGPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=847e96bce86d8774f491a92924343a29"

PYPI_PACKAGE_EXT = "tar.gz"

SRC_URI[md5sum] = "7f3f4259000dc77ef2f73d7d32bd9591"
SRC_URI[sha256sum] = "1d5cfa74117193b244a4233f246c483d9f41198b448c5f14a8bad11c4f649f2b"

inherit pypi setuptools3

DEPENDS += " \
        ${PYTHON_PN}-pip \
        "

RDEPENDS:${PN} += " \
        "

