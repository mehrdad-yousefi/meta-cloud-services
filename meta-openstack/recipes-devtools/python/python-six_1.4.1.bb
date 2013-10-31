DESCRIPTION = "Python 2 and 3 compatibility utilities"
HOMEPAGE = "http://pypi.python.org/pypi/six/"
SECTION = "devel/python"
LICENSE = "UNKNOWN"
LIC_FILES_CHKSUM = "file://LICENSE;md5=aa39e09066d6ba3a8c8b2db7cbd8bd70"

PR = "r0"
SRCNAME = "six"

SRC_URI = "https://pypi.python.org/packages/source/s/${SRCNAME}/${SRCNAME}-${PV}.tar.gz \
"

SRC_URI[md5sum] = "bdbb9e12d3336c198695aa4cf3a61d62"
SRC_URI[sha256sum] = "f045afd6dffb755cc0411acb7ce9acc4de0e71261d4b5f91de2e68d9aa5f8367"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils 
