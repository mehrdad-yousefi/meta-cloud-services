DESCRIPTION = "OpenStackClient Library"
HOMEPAGE = "http://opensource.perlig.de/rcssmin/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

SRC_URI[md5sum] = "62d32a59bf4447191b957c6a65eff47f"
SRC_URI[sha256sum] = "697d08204a59933035ac246fbc8c8e5453b846b4a8875ed7a9e9caba769b1b57"

inherit setuptools3 pypi

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
