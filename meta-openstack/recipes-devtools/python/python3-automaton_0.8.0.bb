DESCRIPTION = "Friendly state machines for python"
HOMEPAGE = "https://pypi.python.org/pypi/automaton"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d2794c0df5b907fdace235a619d80314"

SRC_URI[md5sum] = "230a7bd8bb9a4bc9ba5a3faf0de12c90"
SRC_URI[sha256sum] = "ca8bfbea03b9f39a536b4b261d90fbe8b1b0e1766bff5d8222e35691f8e11910"

inherit setuptools3 pypi

DEPENDS += " \
        python3-pip \
        "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python3-pbr-native \
        "

RDEPENDS_${PN} += " \
        python3-pbr \
        python3-six \
        python3-debtcollector \
        python3-prettytable \
        "

