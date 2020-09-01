DESCRIPTION = "Library for validation of digital signatures."
HOMEPAGE = "https://github.com/openstack/cursive"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

inherit setuptools3 pypi

SRC_URI[sha256sum] = "fbdc2b088bf0b9a69b1897d726e6027e8fba8f21f0a881344f70e7a407d9abda"

DEPENDS += " \
        python3-pbr \
        "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python3-pbr-native \
        "

RDEPENDS_${PN} += " \
        python3-pbr \
        python3-lxml \
        python3-cryptography \
        python3-netifaces \
        python3-six \
        python3-oslo.serialization \
        python3-oslo.utils \
        python3-oslo.i18n \
        python3-oslo.log \
        python3-castellan \
        "
