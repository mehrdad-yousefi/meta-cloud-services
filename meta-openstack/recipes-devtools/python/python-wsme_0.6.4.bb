DESCRIPTION = "Simplify the writing of REST APIs, and extend them with additional protocols"
HOMEPAGE = "https://pypi.python.org/pypi/WSME/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=477dfa54ede28e2f361e7db05941d7a7"

SRCNAME = "WSME"

SRC_URI = "https://pypi.python.org/packages/source/W/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "0ba96f660c10d41c63d6bb65bfeeed59"
SRC_URI[sha256sum] = "e4c0012b1a592c3889697259c690447dfc8edcbae5b52307709705377305e953"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

DEPENDS += " \
        python-pip \
        python-pbr \
        "

RDEPENDS_${PN} += "\
        python-pbr \
        "
