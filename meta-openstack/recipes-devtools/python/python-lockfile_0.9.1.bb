DESCRIPTION = "Platform-independent file locking module"
HOMEPAGE = "http://code.google.com/p/pylockfile/"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2340dffbbfea534b58f1349984eeef72"

PR = "r0"
SRCNAME = "lockfile"

SRC_URI = "https://pylockfile.googlecode.com/files/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "4e4c7ea4c4301500da5e7f3b51e01cfe"
SRC_URI[sha256sum] = "88d8ea8d435ee5691117a87d1ca8fed2f8da881eb145295bf6895ac2c416e95d"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils 
