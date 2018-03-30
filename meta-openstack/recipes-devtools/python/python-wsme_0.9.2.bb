DESCRIPTION = "Simplify the writing of REST APIs, and extend them with additional protocols"
HOMEPAGE = "https://pypi.python.org/pypi/WSME/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5a9126e7f56a0cf3247050de7f10d0f4"

PYPI_PACKAGE = "WSME"

SRC_URI[md5sum] = "f7ab1fecd5fa64f579d6ef3aabf38f60"
SRC_URI[sha256sum] = "e790ac755a7e36eaa796d3966d3878677896dbc7d1c2685cb85c06b744c21976"

inherit setuptools pypi

DEPENDS += " \
        python-pip \
        python-pbr \
        "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python-pbr-native \
        "

RDEPENDS_${PN} += "\
        python-pbr \
        "
