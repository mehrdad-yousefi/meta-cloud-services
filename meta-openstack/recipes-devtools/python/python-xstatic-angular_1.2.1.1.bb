DESCRIPTION = "Angular JavaScript library packaged for setuptools"
HOMEPAGE = "https://pypi.python.org/pypi/XStatic-Angular"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=7e6bb42b0e414f5151db54e18332cd10"

PR = "r0"

SRCNAME = "XStatic-Angular"
SRC_URI = "http://pypi.python.org/packages/source/X/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "062f1590769f9afef17110a637a29461"
SRC_URI[sha256sum] = "8ee63c5fbb3c4dad16f09c5467f1e71229a5e8b63d2993e761d81cdf86f72bae"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

# DEPENDS_default: python-pip

DEPENDS += " \
        python-pip \
        "

# RDEPENDS_default: 
RDEPENDS_${PN} += " \
        "
