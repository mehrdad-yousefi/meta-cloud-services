DESCRIPTION = "Highly concurrent networking library"
HOMEPAGE = "http://pypi.python.org/pypi/eventlet"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=56472ad6de4caf50e05332a34b66e778"

PR = "r0"
SRCNAME = "eventlet"

SRC_URI = "http://pypi.python.org/packages/source/e/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "207119abce774018432225bd719403fb"
SRC_URI[sha256sum] = "07937754fcaf9a21995a5973a4b5ef367d5ad534366a876d5da958d8cfd6415d"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
