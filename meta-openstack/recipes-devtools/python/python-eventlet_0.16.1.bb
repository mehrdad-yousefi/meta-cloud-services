DESCRIPTION = "Highly concurrent networking library"
HOMEPAGE = "http://pypi.python.org/pypi/eventlet"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=56472ad6de4caf50e05332a34b66e778"

PR = "r0"
SRCNAME = "eventlet"

SRC_URI = "http://pypi.python.org/packages/source/e/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "58f6e5cd1bcd8ab78e32a2594aa0abad"
SRC_URI[sha256sum] = "e8bfd7ba6bbf2223a7cd3b1ffec2f15ab28a2ef65171b57dddd4323c7ac24db7"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
