DESCRIPTION = "Platform-independent file locking module"
HOMEPAGE = "http://code.google.com/p/pylockfile/"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2340dffbbfea534b58f1349984eeef72"

PR = "r0"
SRCNAME = "lockfile"

SRC_URI = "https://pypi.python.org/packages/source/l/lockfile/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "ce61468d4c1263e3005737bbed2641f0"
SRC_URI[sha256sum] = "23da589c91f59cb7c644d5ce5df539d448341bd479917d6dde973f82e2719147"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils 
