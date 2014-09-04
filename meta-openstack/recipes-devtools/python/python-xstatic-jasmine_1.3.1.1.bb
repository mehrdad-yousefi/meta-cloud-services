DESCRIPTION = "Jasmine JavaScript library packaged for setuptools "
HOMEPAGE = "https://pypi.python.org/pypi/XStatic-Jasmine"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=dfe5bf1328f6947f43208400409167b0"

PR = "r0"

SRCNAME = "XStatic-Jasmine"
SRC_URI = "http://pypi.python.org/packages/source/X/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "343a6848f32a0ec5015d8732a82b130b"
SRC_URI[sha256sum] = "b9a8f8f0bf51ebdf7118c598c2e62b10ad9e1326858dbb61a07b3711b9491465"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

# DEPENDS_default: python-pip

DEPENDS += " \
        python-pip \
        "

# RDEPENDS_default: 
RDEPENDS_${PN} += " \
        "
