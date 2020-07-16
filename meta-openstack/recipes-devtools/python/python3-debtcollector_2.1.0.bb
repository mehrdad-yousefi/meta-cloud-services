DESCRIPTION = "A collection of Python deprecation patterns and strategies that help you collect your technical debt in a non-destructive manner."
HOMEPAGE = "http://docs.openstack.org/developer/debtcollector/"
SECTION = "devel/python"
LICENSE = "Apache-2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI[md5sum] = "9a1014f18abbc565b8e149fd70048c22"
SRC_URI[sha256sum] = "a25fc6215560d81cb9f2a0b58d6c834f2a24010987027bde169599e138a205af"

inherit setuptools3 pypi

DEPENDS += " \
        ${PYTHON_PN}-pip \
        ${PYTHON_PN}-pbr \
        "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        ${PYTHON_PN}-pbr-native \
        "

# RDEPENDS_default:
RDEPENDS_${PN} += " \
        ${PYTHON_PN}-pbr \
        ${PYTHON_PN}-wrapt \
        ${PYTHON_PN}-six \
        "
