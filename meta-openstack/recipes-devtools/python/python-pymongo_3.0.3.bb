DESCRIPTION = "Python driver for MongoDB"
HOMEPAGE = "https://pypi.python.org/pypi/pymongo/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a944942e1496af1886903d274dedb13"

SRCNAME = "pymongo"

SRC_URI = "https://pypi.python.org/packages/source/p/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "0425d99c2a453144b9c95cb37dbc46e9"
SRC_URI[sha256sum] = "3c6b2317f8031bc1e200fd1ea35f00a96f4569e3f3f220a5e66ab6227d96ccaf"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
