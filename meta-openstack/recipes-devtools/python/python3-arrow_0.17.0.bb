DESCRIPTION = "Better dates and times for Python"
HOMEPAGE = "https://github.com/crsmithdev/arrow"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=62e977be69cd001d6545038b6bb1575c"

SRC_URI[md5sum] = "76d66d0d03effad1407fb4dcebce9566"
SRC_URI[sha256sum] = "ff08d10cda1d36c68657d6ad20d74fbea493d980f8b2d45344e00d6ed2bf6ed4"

inherit setuptools3 pypi

RDEPENDS:${PN} += " \
        ${PYTHON_PN}-dateutil \
        "
