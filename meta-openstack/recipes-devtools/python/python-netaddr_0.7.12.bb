DESCRIPTION = "A library for network address representation and manipulation"
HOMEPAGE = "https://github.com/drkjam/netaddr"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e0c5cc28e66c19626bc908b3a9402c2e"

PR = "r0"
SRCNAME = "netaddr"

SRC_URI = "https://pypi.python.org/packages/source/n/${SRCNAME}/${SRCNAME}-${PV}.zip"

SRC_URI[md5sum] = "6145afd46786ffbc6644ae1ea2bfefd7"
SRC_URI[sha256sum] = "622b81e571fb974698d056d4825b21ee64eac96de8ef41327b03913ac4308d5b"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils
