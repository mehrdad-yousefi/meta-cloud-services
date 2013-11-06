DESCRIPTION = "Manage dynamic plugins for Python applications"
HOMEPAGE = "https://github.com/dreamhost/stevedore"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

PR = "r0"

SRCNAME = "stevedore"
SRC_URI = "http://pypi.python.org/packages/source/s/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "8bf1b7bed06bf5ab636784d161f1a494"
SRC_URI[sha256sum] = "9689a76c09eaeb60b6db5b45aae71de8c53f15d302d790536ac5bf7c47d729eb"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
