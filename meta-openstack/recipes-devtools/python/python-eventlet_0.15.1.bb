DESCRIPTION = "Highly concurrent networking library"
HOMEPAGE = "http://pypi.python.org/pypi/eventlet"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=56472ad6de4caf50e05332a34b66e778"

PR = "r0"
SRCNAME = "eventlet"

SRC_URI = "http://pypi.python.org/packages/source/e/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "7155780824bb6344651a573838416f21"
SRC_URI[sha256sum] = "2b2ec222aba392bde157168000f0827c493f756a06dab7bc346b46439fd0f6ae"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
