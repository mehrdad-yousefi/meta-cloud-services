DESCRIPTION = "Python Build Reasonableness: PBR is a library that injects some useful and sensible default behaviors into your setuptools run"
HOMEPAGE = "https://pypi.python.org/pypi/pbr"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

PR = "r0"
SRCNAME = "pbr"

SRC_URI = "https://pypi.python.org/packages/source/p/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "74ed7d0a9d93c1ab3eb7000e2c0482c7"
SRC_URI[sha256sum] = "d82d78422625a78f89fb341fb0243320b09c18caac6e7770105ba62dd7d8b445"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools


