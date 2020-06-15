DESCRIPTION = "Useful additions to futures, from the future"
HOMEPAGE = "https://pypi.python.org/pypi/futurist"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

SRC_URI[md5sum] = "708ae19b7e3bef70b47166da1e72392c"
SRC_URI[sha256sum] = "3601ea64e3423b169683cffff58939ecee5cd5268834b20bf2da071c2563a43c"

inherit setuptools3 pypi

DEPENDS += " \
        python3-pip \
        python3-pbr-native \
        "

RDEPENDS_${PN} += " \
        python3-pbr \
        python3-six \
        python3-monotonic \
        python3-contextlib2 \
        python3-prettytable \
        "

