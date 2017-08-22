DESCRIPTION = "Library to enforce positional or key-word arguments"
HOMEPAGE = "https://github.com/morganfainberg/positional"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5335066555b14d832335aa4660d6c376"

SRCNAME = "positional"
SRC_URI = "https://pypi.io/packages/source/p/${SRCNAME}/${SRCNAME}-${PV}.tar.gz \
"

SRC_URI[md5sum] = "c82903c32c1aec1ac0f0f6e166ef4e2e"
SRC_URI[sha256sum] = "ef845fa46ee5a11564750aaa09dd7db059aaf39c44c901b37181e5ffa67034b0"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

CLEANBROKEN = "1"

RDEPENDS_${PN} += " \
    python-wrapt \
"