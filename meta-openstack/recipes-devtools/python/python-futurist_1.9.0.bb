DESCRIPTION = "Useful additions to futures, from the future"
HOMEPAGE = "https://pypi.python.org/pypi/futurist"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

SRC_URI[md5sum] = "cbfa47202a5724215edc83cc91bdf0ac"
SRC_URI[sha256sum] = "0c58c359d0fa09852841efc587870db4c186c7a9175768176f69013c8acd83a6"

inherit setuptools pypi

DEPENDS += " \
        python-pip \
        python-pbr-native \
        "

RDEPENDS_${PN} += " \
        python-pbr \
        python-six \
        python-monotonic \
        python-futures \
        python-contextlib2 \
        python-prettytable \
        "

