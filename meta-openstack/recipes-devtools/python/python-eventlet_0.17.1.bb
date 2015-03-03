DESCRIPTION = "Highly concurrent networking library"
HOMEPAGE = "http://pypi.python.org/pypi/eventlet"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=56472ad6de4caf50e05332a34b66e778"

PR = "r0"
SRCNAME = "eventlet"

SRC_URI = "http://pypi.python.org/packages/source/e/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "b66053e6dbfd5a6996750fa09b0af6ba"
SRC_URI[sha256sum] = "de9c23eb94e55150b25150822a28f91656028987353fef3f687cc285d018dd5a"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
