DESCRIPTION = "Python driver for MongoDB"
HOMEPAGE = "https://pypi.python.org/pypi/pymongo/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a944942e1496af1886903d274dedb13"

SRCNAME = "pymongo"

SRC_URI = "https://pypi.python.org/packages/82/26/f45f95841de5164c48e2e03aff7f0702e22cef2336238d212d8f93e91ea8/${SRCNAME}-${PV}.tar.gz"
 
SRC_URI[md5sum] = "aa77f88e51e281c9f328cea701bb6f3e"
SRC_URI[sha256sum] = "d359349c6c9ff9f482805f89e66e476846317dc7b1eea979d7da9c0857ee2721"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
