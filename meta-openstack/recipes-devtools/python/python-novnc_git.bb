DESCRIPTION = "This package contains the core python parts of NoVNC"
HOMEPAGE = "https://github.com/kanaka/noVNC"
SECTION = "devel/python"

PR = "r0"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=ac06308a999996ffc2d24d81b3a39f1b"

SRCREV = "8f12ca7a5a64144fe548cada332d5d19ef26a1fe"
PV = "0.4+git${SRCPV}"

SRC_URI = "git://github.com/kanaka/noVNC.git \
           file://python-distutils.patch"

S = "${WORKDIR}/git"

inherit distutils
