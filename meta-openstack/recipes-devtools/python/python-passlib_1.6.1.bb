DESCRIPTION = "comprehensive password hashing framework supporting over 30 schemes"
HOMEPAGE = "http://passlib.googlecode.com"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ec76a9db3f987418e132c0f0210e5ab1"

PR = "r0"
SRCNAME = "passlib"

SRC_URI = "https://pypi.python.org/packages/source/p/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "6354846f965694db402fba4125205315"
SRC_URI[sha256sum] = "00cfb564feb2d97ebaf6b28acdc9277a0c73c3c1df7b2a7b65605c76e724177b"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
