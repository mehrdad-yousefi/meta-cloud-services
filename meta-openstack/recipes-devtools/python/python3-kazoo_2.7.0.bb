DESCRIPTION = "Higher Level Zookeeper Client"
HOMEPAGE = "https://kazoo.readthedocs.org"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

# Archived version so we have to overwrite what the pypi class will derive
SRCNAME = "kazoo"

PYPI_SRC_URI = "https://pypi.python.org/packages/source/k/${SRCNAME}/kazoo-${PV}.tar.gz"

SRC_URI[md5sum] = "073445f65d71520de2b6275530d88c4e"
SRC_URI[sha256sum] = "6883f6dd3e8d4e1741076dd3b23b0861592f13759072e3835f035bcb72b077cb"

inherit setuptools3 pypi

# DEPENDS_default: python3-pip

DEPENDS += " \
        python3-pip \
        "

# RDEPENDS_default: 
RDEPENDS_${PN} += " \
        "
