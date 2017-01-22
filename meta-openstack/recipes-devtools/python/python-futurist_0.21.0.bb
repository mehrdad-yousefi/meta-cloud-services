DESCRIPTION = "Useful additions to futures, from the future"
HOMEPAGE = "https://pypi.python.org/pypi/futurist"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

SRCNAME = "futurist"

SRC_URI = "https://pypi.io/packages/source/f/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "da7e87d273f1982c24e9fe8a24f81259"
SRC_URI[sha256sum] = "086dd646c067d4ef6dc9c04000828acfbdc00842bd37c64825b596a6976509b4"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools 

DEPENDS += " \
        python-pip \
        python-pbr-native \
        "

RDEPENDS_${PN} += " \
        python-pbr \
        python-six \
        python-monotonic \
        python-futures \
        python-contextlib2 \
        python-prettytable \
        "

