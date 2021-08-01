DESCRIPTION = "OpenStackClient Library"
HOMEPAGE = "http://opensource.perlig.de/rcssmin/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

SRC_URI[md5sum] = "0fa5c159de19e984323474321a8a02ed"
SRC_URI[sha256sum] = "ee4f8b6989d3a3fb1021a6a32665000b1db27e615a0ab5c86c35eb59c90003f1"

inherit setuptools3 pypi

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        ${PYTHON_PN}-pbr-native \
        "

RDEPENDS:${PN} += " \
        ${PYTHON_PN}-pbr \
        ${PYTHON_PN}-six \
        ${PYTHON_PN}-babel \
        ${PYTHON_PN}-cliff \
        ${PYTHON_PN}-keystoneauth1 \
        ${PYTHON_PN}-os-client-config \
        ${PYTHON_PN}-oslo.i18n \
        ${PYTHON_PN}-oslo.utils \
        ${PYTHON_PN}-simplejson \
        ${PYTHON_PN}-stevedore \
        "

CLEANBROKEN = "1"
