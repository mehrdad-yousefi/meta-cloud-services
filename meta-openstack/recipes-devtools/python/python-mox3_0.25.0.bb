DESCRIPTION = "mox3: mock object framework for Python"
HOMEPAGE = "https://pypi.python.org/pypi/mox3/0.9.0"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING.txt;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI[md5sum] = "77bb9a6a57187b708d822bad05c51e0e"
SRC_URI[sha256sum] = "b7476f7a2dfe4d7ad743e3cbbf04ade624b3a208a0042f3f8b2ae7b00559543a"

inherit setuptools pypi

DEPENDS += "\
    python-pbr \
    "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
    python-pbr-native \
    "

RDEPENDS_${PN} += " \
    python-pbr \
    python-fixtures \
"
