DESCRIPTION = "Python 2 and 3 compatibility utilities"
HOMEPAGE = "http://pypi.python.org/pypi/six/"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=530f34047c21ad45b3199946dd90bea5"

PR = "r1"
SRCNAME = "six"

SRC_URI = "https://pypi.python.org/packages/source/s/${SRCNAME}/${SRCNAME}-${PV}.tar.gz \
"

SRC_URI[md5sum] = "07d606ac08595d795bf926cc9985674f"
SRC_URI[sha256sum] = "d4392a7c8d91b005c002568a85faf617c67241c8cd8399cc395e8f1005aff80d"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
