DESCRIPTION = "Simplify the writing of REST APIs, and extend them with additional protocols"
HOMEPAGE = "https://pypi.python.org/pypi/WSME/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5a9126e7f56a0cf3247050de7f10d0f4"

SRCNAME = "WSME"

SRC_URI = "https://pypi.python.org/packages/source/W/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "0d50fffead72d8a9fcb6152082d5b61b"
SRC_URI[sha256sum] = "1cae2c4df4af93db345ef7a52204b8facab8318aee6b9b56f54f8cb4aac79849"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

DEPENDS += " \
        python-pip \
        python-pbr \
        "

RDEPENDS_${PN} += "\
        python-pbr \
        "
