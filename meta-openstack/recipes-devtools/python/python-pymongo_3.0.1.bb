DESCRIPTION = "Python driver for MongoDB"
HOMEPAGE = "https://pypi.python.org/pypi/pymongo/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a944942e1496af1886903d274dedb13"

SRCNAME = "pymongo"

SRC_URI = "https://pypi.python.org/packages/source/p/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "f2aab37b56229981f975ad1daf61b774"
SRC_URI[sha256sum] = "d26076e838335d33d10f35f5b94a5a618a7aea5519c889b9ec473b23200b1237"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
