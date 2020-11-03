DESCRIPTION = "Useful additions to futures, from the future"
HOMEPAGE = "https://pypi.python.org/pypi/futurist"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

SRC_URI[md5sum] = "4d642f5825a516d676356094179c6d27"
SRC_URI[sha256sum] = "174ea146adf303d7e5d7d6d34e3a01f4abf0382b03a6f9309bac2e2d54ffbed6"

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
        python3-multiprocessing \
        "

