DESCRIPTION = "Authentication Library for OpenStack Identity"
HOMEPAGE = "https://pypi.python.org/pypi/keystoneauth1"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=96f840d59b245a1c817fbcb901afc574"

SRC_URI[md5sum] = "3c65181cb3cf6a8690e1c65de030e3fb"
SRC_URI[sha256sum] = "9496bfcc27eff3d05271e10aa64684b7c1fd12a4d96f58511f2286312d9c89a1"

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
