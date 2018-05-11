DESCRIPTION = "A collection of Python deprecation patterns and strategies that help you collect your technical debt in a non-destructive manner."
HOMEPAGE = "http://docs.openstack.org/developer/debtcollector/"
SECTION = "devel/python"
LICENSE = "Apache-2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI[md5sum] = "d43a2733f02549628fe9f716363a5b01"
SRC_URI[sha256sum] = "1f751d74789baa82684f55bececf754ebff1ad40e3fb1bee44fcf5c25a31e92d"

inherit setuptools pypi

DEPENDS += " \
        python-pip \
        python-pbr \
        "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python-pbr-native \
        "

# RDEPENDS_default:
RDEPENDS_${PN} += " \
        python-pbr \
        python-funcsigs \
        "
