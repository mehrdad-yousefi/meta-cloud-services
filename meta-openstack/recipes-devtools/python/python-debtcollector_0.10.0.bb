DESCRIPTION = "A collection of Python deprecation patterns and strategies that help you collect your technical debt in a non-destructive manner."
HOMEPAGE = "http://docs.openstack.org/developer/debtcollector/"
SECTION = "devel/python"
LICENSE = "Apache-2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRCNAME = "debtcollector"

SRC_URI = "https://pypi.python.org/packages/source/d/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "aaf95f5e44af17be4d6421512d4cf6c3"
SRC_URI[sha256sum] = "8cc22cf2223af7789692ef0b1cb5c0c3a00da7d6e34cbfce125a956cb4d2f21e"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

DEPENDS += " \
        python-pip \
        python-pbr \
        "

# RDEPENDS_default:
RDEPENDS_${PN} += " \
        python-pbr \
        "
