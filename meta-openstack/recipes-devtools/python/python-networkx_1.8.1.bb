DESCRIPTION = "Python package for creating and manipulating graphs and networks"
HOMEPAGE = "http://networkx.lanl.gov/"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=ec88315ae06938d6c6f830327981d0f1"

PR = "r0"

SRCNAME = "networkx"
SRC_URI = "http://pypi.python.org/packages/source/n/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "b4a9e68ecd1b0164446ee432d2e20bd0"
SRC_URI[sha256sum] = "b75ba675fd2831f60e3f5a028822a8f7b9993877854599e9694196f8b2f88233"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

# DEPENDS_default: python-pip

DEPENDS += " \
        python-pip \
        "

# RDEPENDS_default: 
RDEPENDS_${PN} += " \
        "
