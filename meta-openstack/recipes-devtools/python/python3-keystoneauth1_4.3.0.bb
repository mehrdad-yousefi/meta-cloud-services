DESCRIPTION = "Authentication Library for OpenStack Identity"
HOMEPAGE = "https://pypi.python.org/pypi/keystoneauth1"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=96f840d59b245a1c817fbcb901afc574"

SRC_URI[md5sum] = "455ff39860b21e924305f4db3d74e293"
SRC_URI[sha256sum] = "e3fa55b58f082e4d753ae3fe599f3d74c591fd9cb8286879ff532a78955163f1"

inherit setuptools3 pypi

DEPENDS += " \
        ${PYTHON_PN}-pbr \
        "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        ${PYTHON_PN}-pbr-native \
        "

RDEPENDS_${PN} += " \
        ${PYTHON_PN}-pbr \
        ${PYTHON_PN}-iso8601 \
        ${PYTHON_PN}-requests \
        ${PYTHON_PN}-six \
        ${PYTHON_PN}-stevedore \
        "
