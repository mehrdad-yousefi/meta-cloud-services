DESCRIPTION = "Better dates and times for Python"
HOMEPAGE = "https://github.com/crsmithdev/arrow"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=62e977be69cd001d6545038b6bb1575c"

SRC_URI[md5sum] = "2176ce6e28a1c43bbdb2ccc79886f420"
SRC_URI[sha256sum] = "3f1a92b25bbee5f80cc8f6bdecfeade9028219229137c559c37335b4f574a292"

inherit setuptools3 pypi

RDEPENDS_${PN} += " \
        ${PYTHON_PN}-dateutil \
        ${PYTHON_PN}-backports-functools-lru-cache \
        "
