DESCRIPTION = "pyScss, a Scss compiler for Python"
HOMEPAGE = "http://github.com/Kronuz/pyScss"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=28155276e8df3f75bbd327335f66f2fa"

PR = "r0"

SRCNAME = "pyScss"
SRC_URI = "http://pypi.python.org/packages/source/p/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "9f0a84addbe2f2eb2650c7c63078f4cc"
SRC_URI[sha256sum] = "f08d35992b70298453bfb7e0ada649d639f3f616730fdd16e59c6289c22b5b00"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

# DEPENDS_default: python-pip

DEPENDS += " \
        python-pip \
        "

# RDEPENDS_default: 
RDEPENDS_${PN} += " \
        "
