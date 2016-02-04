DESCRIPTION = "Manage dynamic plugins for Python applications"
HOMEPAGE = "https://github.com/dreamhost/stevedore"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"


SRCNAME = "stevedore"
SRC_URI = "http://pypi.python.org/packages/source/s/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "53e2bc3b49dd9c920cfce7f63822b1a5"
SRC_URI[sha256sum] = "cc19908840498ed5f7cb5cf59bbe47b41aa9d65821548e2b3c8a99a571cbec06"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools rmargparse

DEPENDS += " \
        python-pip \
        python-pbr \
        "

RDEPENDS_${PN} += " \
        python-pbr \
        python-argparse \
        "
