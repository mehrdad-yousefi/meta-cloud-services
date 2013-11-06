DESCRIPTION = "WSGI object-dispatching web framework"
HOMEPAGE = "https://pypi.python.org/pypi/pecan/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d846877d24bbb3d7a00a985c90378e8c"

PR = "r0"
SRCNAME = "pecan"

SRC_URI = "https://pypi.python.org/packages/source/p/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "2321ce0eb09ab4ba4cf184b55a6e3c21"
SRC_URI[sha256sum] = "72aea7ffe4085944beec4134ad8bff31fcea13cf900f11e9b31f7470863916f8"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
