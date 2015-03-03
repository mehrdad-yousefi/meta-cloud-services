DESCRIPTION = "Backport of the concurrent.futures package from Python 3.2"
HOMEPAGE = "http://code.google.com/p/pythonfutures"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=dd6708d05936d3f6c4e20ed14c87b5e3"

PR = "r0"

SRCNAME = "futures"
SRC_URI = "http://pypi.python.org/packages/source/f/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "cfab9ac3cd55d6c7ddd0546a9f22f453"
SRC_URI[sha256sum] = "33f39102b631fa0a030b24c4341ba1f48558e435946d6735d47fe1f739d757c4"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

# DEPENDS_default: python-pip

DEPENDS += " \
        python-pip \
        "

# RDEPENDS_default: 
RDEPENDS_${PN} += " \
        "
