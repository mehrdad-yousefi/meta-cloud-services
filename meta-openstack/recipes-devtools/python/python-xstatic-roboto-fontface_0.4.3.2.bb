DESCRIPTION = "A simple package providing the Roboto fontface."
HOMEPAGE = "https://github.com/choffmeister/roboto-fontface-bower"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=7eeeb6915ae97fbbac6282f36b6fcaaa"

SRCNAME = "XStatic-roboto-fontface"
SRC_URI = "https://pypi.python.org/packages/source/X/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "2a19734d8e08bbe1413f37e703e288f8"
SRC_URI[sha256sum] = "e539aa991300d8ee09ee557d3cab1066237806e365ceaf868084777379e307a5"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

DEPENDS += " \
        python-pip \
        "

RDEPENDS_${PN} += " \
        "
