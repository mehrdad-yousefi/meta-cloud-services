DESCRIPTION = "mox3: mock object framework for Python"
HOMEPAGE = "https://pypi.python.org/pypi/mox3/0.9.0"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING.txt;md5=3b83ef96387f14655fc854ddc3c6bd57"

PR = "r0"

SRCNAME = "mox3"
SRC_URI = "https://pypi.python.org/packages/d8/a8/64e78823c52d719181100e9e01dd3485a6e064e79e402089ba4e33cfaed6/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "53be7bf2d109c8bdf477c75b369773b8"
SRC_URI[sha256sum] = "7b1549222353f6cc5b705734ef186fe2cc323d30c3987df50eceb77273595606"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

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
