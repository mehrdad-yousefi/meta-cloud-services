DESCRIPTION = "pyScss, a Scss compiler for Python"
HOMEPAGE = "http://github.com/Kronuz/pyScss"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=28155276e8df3f75bbd327335f66f2fa"

PR = "r0"

SRCNAME = "pyScss"
SRC_URI = "http://pypi.python.org/packages/source/p/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "9a5c24922643f6e90ea03d520700521b"
SRC_URI[sha256sum] = "6f486363f5fac20d218dc5d11b8af4e5b52242a59e5067f42ca227152a7df3cc"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

# DEPENDS_default: python-pip

DEPENDS += " \
        python-pip \
        libpcre \
        "

# RDEPENDS_default: 
RDEPENDS_${PN} += " \
        "
