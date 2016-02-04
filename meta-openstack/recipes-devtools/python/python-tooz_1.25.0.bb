DESCRIPTION = "Coordination library for distributed systems."
HOMEPAGE = "https://pypi.python.org/pypi/tooz"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"


SRCNAME = "tooz"
SRC_URI = "http://pypi.python.org/packages/source/t/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "939eaf6c5e49d3a41e8c9f2e92126cfc"
SRC_URI[sha256sum] = "d61639640b8e4fc64195306f8fae92cf271a002c690bf693ee51f9790cf8141e"

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
        python-babel \
        python-stevedore \
        python-six \
        python-iso8601 \
        python-msgpack \
        python-fasteners \
        python-retrying \
        python-futurist \
        python-oslo.utils \
        python-oslo.serialization \
        python-futures \
        "
