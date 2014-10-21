DESCRIPTION = "Highly concurrent networking library"
HOMEPAGE = "http://pypi.python.org/pypi/eventlet"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=56472ad6de4caf50e05332a34b66e778"

PR = "r0"
SRCNAME = "eventlet"

SRC_URI = "http://pypi.python.org/packages/source/e/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "c5b0217cc1da6fcf4bcf6957df57f3cd"
SRC_URI[sha256sum] = "eaec368ce7b819f8615dcb51f63dcb5c910538cdedc99e4bba4c90ed0bf70fdc"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
