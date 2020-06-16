DESCRIPTION = "mox3: mock object framework for Python"
HOMEPAGE = "https://pypi.python.org/pypi/mox3"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING.txt;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI[md5sum] = "0eff74d3a85ec4d4dc6acf7f524ca816"
SRC_URI[sha256sum] = "8a526b7b9b6341f541a9aef3e08c93fd84a5373fe89d4cc51dd571f085b2363c"

inherit setuptools3 pypi

DEPENDS += "\
    python3-pbr \
    "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
    python3-pbr-native \
    "

RDEPENDS_${PN} += " \
    python3-pbr \
    python3-fixtures \
"
