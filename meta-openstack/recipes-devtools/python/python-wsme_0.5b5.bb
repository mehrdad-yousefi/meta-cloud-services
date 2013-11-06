DESCRIPTION = "Simplify the writing of REST APIs, and extend them with additional protocols"
HOMEPAGE = "https://pypi.python.org/pypi/WSME/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=477dfa54ede28e2f361e7db05941d7a7"

PR = "r0"
SRCNAME = "WSME"

SRC_URI = "https://pypi.python.org/packages/source/W/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "88764f4923e83bd995940ef06eb42aa7"
SRC_URI[sha256sum] = "7d8bf27e78d4c701c10a1f0047f4cf7e375ffc458bf88bb10a12efb98695be1a"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
