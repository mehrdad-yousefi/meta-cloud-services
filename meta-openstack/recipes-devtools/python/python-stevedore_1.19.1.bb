DESCRIPTION = "Manage dynamic plugins for Python applications"
HOMEPAGE = "https://github.com/dreamhost/stevedore"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"


SRCNAME = "stevedore"
SRC_URI = "http://pypi.io/packages/source/s/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "f02de21fc0efac440db3a6d716068669"
SRC_URI[sha256sum] = "c963858176fdbac899859a9e215411d024e3a46655034a853e0f3b57947c9856"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools rmargparse

DEPENDS += " \
        python-pip \
        python-pbr \
        "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python-pbr-native \
        "

RDEPENDS_${PN} += " \
        python-pbr \
        python-argparse \
        python-six \
        "
