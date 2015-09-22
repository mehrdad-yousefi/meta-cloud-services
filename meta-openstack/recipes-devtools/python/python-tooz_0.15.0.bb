DESCRIPTION = "Coordination library for distributed systems."
HOMEPAGE = "https://pypi.python.org/pypi/tooz"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"


SRCNAME = "tooz"
SRC_URI = "http://pypi.python.org/packages/source/t/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "741a416818c47b26a6017152daad22ce"
SRC_URI[sha256sum] = "3a6ae76d8eae96092db0ed340c6ab4bf4d1418eaa19d659a7a56a92227134eb3"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

# DEPENDS_default: python-pip

DEPENDS += " \
        python-pip \
        python-pbr \
        "

# RDEPENDS_default: 
RDEPENDS_${PN} += " \
        python-kazoo \
        python-zake \
        python-sysv-ipc \
        python-memcache \
        python-pbr \
        "
