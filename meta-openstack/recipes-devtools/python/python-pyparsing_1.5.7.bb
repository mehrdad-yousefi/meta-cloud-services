DESCRIPTION = "Python parsing module"
HOMEPAGE = "http://pyparsing.wikispaces.com/"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fb46329938e6bc829b256e37d5c1e31a"

PR = "r0"
SRCNAME = "pyparsing"

SRC_URI = "http://pypi.python.org/packages/source/p/${SRCNAME}/${SRCNAME}-${PV}.zip"

SRC_URI[md5sum] = "b86854857a368d6ccb4d5b6e76d0637f"
SRC_URI[sha256sum] = "8a6329d4679fb249d4e0a4afbae6e041f9abbc299920d6efe5d8c4e9fb1407bc"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils
