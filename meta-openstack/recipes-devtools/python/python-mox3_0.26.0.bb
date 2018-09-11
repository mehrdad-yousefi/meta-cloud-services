DESCRIPTION = "mox3: mock object framework for Python"
HOMEPAGE = "https://pypi.python.org/pypi/mox3/0.9.0"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING.txt;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI[md5sum] = "c05b14ecb25d040f00b0d5ef3b370e20"
SRC_URI[sha256sum] = "b13c0b8459d6fb0688f9a4e70feeec43fa2cca05b727fc01156789596e083bb1"

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
