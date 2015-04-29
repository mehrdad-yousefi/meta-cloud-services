DESCRIPTION = "Highly concurrent networking library"
HOMEPAGE = "http://pypi.python.org/pypi/eventlet"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=56472ad6de4caf50e05332a34b66e778"

SRCNAME = "eventlet"

SRC_URI = "http://pypi.python.org/packages/source/e/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "12c855e37dd688d3137ecc88d5b8f05b"
SRC_URI[sha256sum] = "d39e4124a7b10055c78d5c51c2ee23789a8ebf4f8b811fee4533542ecd3ac99a"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
