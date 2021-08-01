DESCRIPTION = "Higher Level Zookeeper Client"
HOMEPAGE = "https://kazoo.readthedocs.org"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

# Archived version so we have to overwrite what the pypi class will derive
SRCNAME = "kazoo"

PYPI_SRC_URI = "https://pypi.python.org/packages/source/k/${SRCNAME}/kazoo-${PV}.tar.gz"

SRC_URI[md5sum] = "5b2667e9c3f7b92675aef16c14cef97c"
SRC_URI[sha256sum] = "588e27868e4a0ed70ae4a7a5b0f3bca4cec5e5c49dbd7e41349c0883182bf2fe"

inherit setuptools3 pypi

# DEPENDS_default: python3-pip

DEPENDS += " \
        python3-pip \
        "

# RDEPENDS:default: 
RDEPENDS:${PN} += " \
        "
