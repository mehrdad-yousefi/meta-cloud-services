DESCRIPTION = "Portable network interface information."
HOMEPAGE = "http://alastairs-place.net/netifaces"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PR = "r0"
SRCNAME = "netifaces"

SRC_URI = "http://alastairs-place.net/projects/netifaces/netifaces-0.8.tar.gz \
"

SRC_URI[md5sum] = "e57e5983f4c286fac5f8068fbfc5c873"
SRC_URI[sha256sum] = "53a711038db3d6e5cf7129d6f751185fd052f830f12f271fbfe17bd2671ab1ec"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
