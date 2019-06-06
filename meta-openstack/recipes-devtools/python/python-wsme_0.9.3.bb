DESCRIPTION = "Simplify the writing of REST APIs, and extend them with additional protocols"
HOMEPAGE = "https://pypi.python.org/pypi/WSME/"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5a9126e7f56a0cf3247050de7f10d0f4"

PYPI_PACKAGE = "WSME"

SRC_URI[md5sum] = "e6cb3864bae872acaa0cd0c2efacc94f"
SRC_URI[sha256sum] = "e24fcff24392a0b176e560ffc6591b1f658342bbc992f84e0e8a3c53fd92580a"

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
