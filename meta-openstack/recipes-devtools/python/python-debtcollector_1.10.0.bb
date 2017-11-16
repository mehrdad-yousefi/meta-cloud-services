DESCRIPTION = "A collection of Python deprecation patterns and strategies that help you collect your technical debt in a non-destructive manner."
HOMEPAGE = "http://docs.openstack.org/developer/debtcollector/"
SECTION = "devel/python"
LICENSE = "Apache-2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI[md5sum] = "c85d9e0e7d4d00577695214cb425c5b4"
SRC_URI[sha256sum] = "1a3bd886d6aea3775e5366d7335c856449144c0218209af6c660f6be111714a3"

inherit setuptools pypi

DEPENDS += " \
        python-pip \
        python-pbr \
        "

# RDEPENDS_default:
RDEPENDS_${PN} += " \
        python-pbr \
        python-funcsigs \
        "
