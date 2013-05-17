DESCRIPTION = "Simple module to parse ISO 8601 dates"
HOMEPAGE = "http://code.google.com/p/pyiso8601/"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a3d9208be070c24e80961fa0df45128a"

PR = "r0"
SRCNAME = "iso8601"

SRC_URI = "http://pypi.python.org/packages/source/i/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "f63c17a1786b9fe48d05b43d61970f85"
SRC_URI[sha256sum] = "7a28ccdfb316960431aa7f589f71cb10e0675917e36f6d718d9c03ec6e97f60d"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools 
