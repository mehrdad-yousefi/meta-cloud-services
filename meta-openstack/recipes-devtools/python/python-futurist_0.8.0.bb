DESCRIPTION = "Useful additions to futures, from the future"
HOMEPAGE = "https://pypi.python.org/pypi/futurist"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

SRCNAME = "futurist"

SRC_URI = "https://pypi.python.org/packages/source/f/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "ccef2f5a651fffcfe13c71d91262be4d"
SRC_URI[sha256sum] = "36f48b56af54c44db848fe4a23c2cb70bd334237e11212a16885a55aca881ddd"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools 

DEPENDS += " \
        python-pip \
        "

RDEPENDS_${PN} += " \
        python-futures \
        python-contextlib2 \
        "

