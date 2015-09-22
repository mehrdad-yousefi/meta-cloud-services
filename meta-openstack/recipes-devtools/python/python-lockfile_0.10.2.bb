DESCRIPTION = "Platform-independent file locking module"
HOMEPAGE = "http://code.google.com/p/pylockfile/"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2340dffbbfea534b58f1349984eeef72"

SRCNAME = "lockfile"

SRC_URI = "https://pypi.python.org/packages/source/l/lockfile/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "1aa6175a6d57f082cd12e7ac6102ab15"
SRC_URI[sha256sum] = "9e42252f17d1dd89ee31745e0c4fbe58862c25147eb0ef5295c9cd9bcb4ea2c1"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils 

DEPENDS += "\
    python-pbr \
    "

RDEPENDS_${PN} += "\
    python-pbr \
    "
