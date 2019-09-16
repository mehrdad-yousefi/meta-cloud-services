DESCRIPTION = "OpenStackClient Library"
HOMEPAGE = "http://opensource.perlig.de/rcssmin/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

SRC_URI[md5sum] = "5e91028524b50a72f9913ccd2994cf77"
SRC_URI[sha256sum] = "9dcd3b55bd887525a7020a8adbabb661a340fc4a4a707950dc1c6f0b286cce77"

inherit pypi

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        ${PYTHON_PN}-pbr-native \
        "

RDEPENDS_${PN} += " \
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
