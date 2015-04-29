DESCRIPTION = "Validating URI References per RFC 3986"
HOMEPAGE = "https://rfc3986.rtfd.org"
SECTION = "devel/python"
LICENSE = "Apache-2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=03731a0e7dbcb30cecdcec77cc93ec29"


SRCNAME = "rfc3986"
SRC_URI = "http://pypi.python.org/packages/source/r/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "84151eec209c99e71edc760745510da4"
SRC_URI[sha256sum] = "85aec4beb1edc4fa7cb7466cca1410237cb3e344968d07126e428bc62adb8f3c"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

# DEPENDS_default: python-pip

DEPENDS += " \
        python-pip \
        "

# RDEPENDS_default: 
RDEPENDS_${PN} += " \
        "
