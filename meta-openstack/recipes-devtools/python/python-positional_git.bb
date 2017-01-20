DESCRIPTION = "Library to enforce positional or key-word arguments"
HOMEPAGE = "https://github.com/morganfainberg/positional"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5335066555b14d832335aa4660d6c376"

SRCNAME = "positional"
SRC_URI = "git://github.com/morganfainberg/positional \
"

PV = "1.1.1+git${SRCPV}"
SRCREV = "1f5e9fc0f50e9e774fc4db27f97f9acae5f0c29f"

S = "${WORKDIR}/git"

inherit setuptools

CLEANBROKEN = "1"

RDEPENDS_${PN} += " \
    python-wrapt \
"