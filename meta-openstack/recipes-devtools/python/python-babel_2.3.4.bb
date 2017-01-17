DESCRIPTION = "A collection of tools for internationalizing Python applications"
HOMEPAGE = "http://babel.edgewall.org/"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e6eeaabc92cfc2d03f53e789324d7292"

SRCNAME = "Babel"
SRC_URI = "https://pypi.io/packages/source/B/${SRCNAME}/${SRCNAME}-${PV}.tar.gz \
"

SRC_URI[md5sum] = "afa20bc55b0e991833030129ad498f35"
SRC_URI[sha256sum] = "c535c4403802f6eb38173cd4863e419e2274921a01a8aad8a5b497c131c62875"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

CLEANBROKEN = "1"

RDEPENDS_${PN} += " \
    python-pytz \
"