DESCRIPTION = "Validating URI References per RFC 3986"
HOMEPAGE = "https://rfc3986.rtfd.org"
SECTION = "devel/python"
LICENSE = "Apache-2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=03731a0e7dbcb30cecdcec77cc93ec29"

SRC_URI[md5sum] = "1b03ad2853e33d47eea698571255247c"
SRC_URI[sha256sum] = "112398da31a3344dc25dbf477d8df6cb34f9278a94fee2625d89e4514be8bb9d"

inherit setuptools3 pypi

# DEPENDS_default: python-pip

DEPENDS += " \
        ${PYTHON_PN}-pip \
        "

# RDEPENDS:default: 
RDEPENDS:${PN} += " \
        "
