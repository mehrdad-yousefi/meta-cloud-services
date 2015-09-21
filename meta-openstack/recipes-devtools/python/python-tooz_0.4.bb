DESCRIPTION = "Coordination library for distributed systems."
HOMEPAGE = "https://pypi.python.org/pypi/tooz"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

PR = "r0"

SRCNAME = "tooz"
SRC_URI = "http://pypi.python.org/packages/source/t/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "26c2ff05188be7a4ba9d13ef54a6280c"
SRC_URI[sha256sum] = "4db6b9058f2886af067bb81b8f757de095fc7a0bb24beef82c769478229ee595"

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
