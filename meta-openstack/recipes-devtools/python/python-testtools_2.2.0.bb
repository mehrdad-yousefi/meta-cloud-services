DESCRIPTION = "Extensions to the Python standard library unit testing framework"
HOMEPAGE = "https://pypi.python.org/pypi/testtools/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e2c9d3e8ba7141c83bfef190e0b9379a"

PR = "r0"
SRCNAME = "testtools"

SRC_URI = "https://pypi.python.org/packages/0d/72/3212c1723d49f5b58fca736dabdd2e74f38435076d943f4a642117f04d65/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "adef817b07ba24fd6d807fd41a4f1ef4"
SRC_URI[sha256sum] = "80f606607a6e4ce4d0e24e5b786562aa42c581906f3c070607a4265f3da65810"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
DEPENDS += " \
    python-pbr \
    "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
    python-pbr-native \
    "

RDEPENDS_${PN} += "\
    python-extras \
    python-pbr \
    "
