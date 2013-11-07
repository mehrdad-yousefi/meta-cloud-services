DESCRIPTION = "Simple module to parse ISO 8601 dates"
HOMEPAGE = "http://code.google.com/p/pyiso8601/"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ffb8415711cf5d3b081b87c3d0aff737"

PR = "r0"
SRCNAME = "iso8601"

SRC_URI = "http://pypi.python.org/packages/source/i/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "b207ad4f2df92810533ce6145ab9c3e7"
SRC_URI[sha256sum] = "13858f8bfa913ccc0a08649598da7fe9d43197e546dd71f0aa7ad57c65196368"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools 
