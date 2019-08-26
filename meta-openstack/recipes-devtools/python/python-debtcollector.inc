DESCRIPTION = "A collection of Python deprecation patterns and strategies that help you collect your technical debt in a non-destructive manner."
HOMEPAGE = "http://docs.openstack.org/developer/debtcollector/"
SECTION = "devel/python"
LICENSE = "Apache-2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI[md5sum] = "ec899623b37fdee65b888243f0a46735"
SRC_URI[sha256sum] = "f6ce5a383ad73c23e1138dbb69bf45d33f4a4bdec38f02dbf2b89477ec5e55bc"

inherit pypi

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
        "
