DESCRIPTION = "Manage dynamic plugins for Python applications"
HOMEPAGE = "https://github.com/dreamhost/stevedore"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI[md5sum] = "80113d0f3b0f4d64107546dde410003a"
SRC_URI[sha256sum] = "236468dae36707069e8b3bdb455e9f1be090b1e6b937f4ac0c56a538d6f50be0"

inherit setuptools rmargparse pypi

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python-pbr-native \
        "

RDEPENDS_${PN} += " \
        python-pbr \
        python-six \
        "
