DESCRIPTION = "mox3: mock object framework for Python"
HOMEPAGE = "https://pypi.python.org/pypi/mox3"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING.txt;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI[md5sum] = "fa4fd9d9a12c388707c1579e2a6338dc"
SRC_URI[sha256sum] = "210ccaf5829de3e133f0fb8ab798cdb82663aae09b715130fc4765f18234162a"

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
