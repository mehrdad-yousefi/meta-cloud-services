DESCRIPTION = "Python 2 and 3 compatibility utilities"
HOMEPAGE = "http://pypi.python.org/pypi/six/"
SECTION = "devel/python"
LICENSE = "UNKNOWN"
LIC_FILES_CHKSUM = "file://LICENSE;md5=aa39e09066d6ba3a8c8b2db7cbd8bd70"

PR = "r0"
SRCNAME = "six"

SRC_URI = "https://pypi.python.org/packages/source/s/${SRCNAME}/${SRCNAME}-${PV}.tar.gz \
"

SRC_URI[md5sum] = "ec47fe6070a8a64c802363d2c2b1e2ee"
SRC_URI[sha256sum] = "d59793f9b255bd00de800b97f9a50cce4fc8a44c205f7defa5bb7d691d13b852"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils 
