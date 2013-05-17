DESCRIPTION = "WebSockets support for any application/server"
HOMEPAGE = "https://github.com/kanaka/websockify"
SECTION = "devel/python"
LICENSE = "LGPLv3"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=a3b5f97c9d64189899b91b3728bfd774"

PR = "r0"
SRCNAME = "websockify"

SRC_URI = "http://pypi.python.org/packages/source/w/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "29b6549d3421907de4bbd881ecc2e1b1"
SRC_URI[sha256sum] = "e5af73e5d1edee91dbd28bf9fc710b5c23f4183de0e78d5f4fbe68525b53375b"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

RDEPENDS_${PN} += "gmp"
