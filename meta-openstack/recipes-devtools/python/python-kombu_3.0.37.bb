DESCRIPTION = "A messaging framework for Python"
HOMEPAGE = "http://kombu.readthedocs.org"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ee3b641e9940ba25a4dd66b3942866cf"

SRCNAME = "kombu"

SRC_URI = "https://pypi.io/packages/source/k/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "a1901036ba5e70e6b1733f7c2d5ee313"
SRC_URI[sha256sum] = "e064a00c66b4d1058cd2b0523fb8d98c82c18450244177b6c0f7913016642650"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

FILES_${PN}-doc += "${datadir}/${SRCNAME}"

RDEPENDS_${PN} = " \
    python-anyjson \
    python-amqp \
    "
