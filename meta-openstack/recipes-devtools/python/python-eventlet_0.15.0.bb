DESCRIPTION = "Highly concurrent networking library"
HOMEPAGE = "http://pypi.python.org/pypi/eventlet"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=56472ad6de4caf50e05332a34b66e778"

PR = "r0"
SRCNAME = "eventlet"

SRC_URI = "http://pypi.python.org/packages/source/e/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "d40439ab93bd1d22757819a6a1a1737b"
SRC_URI[sha256sum] = "fdd5075ba72688ecb845ddde2b374e8c2c617d02ddd95d68e7505c8aa782637f"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
