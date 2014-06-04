DESCRIPTION = "A client library in python for the Ceph REST API."
HOMEPAGE = "https://github.com/dmsimard/python-cephclient"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d2794c0df5b907fdace235a619d80314"

PR = "r0"

SRCNAME = "python-cephclient"
SRC_URI = "http://pypi.python.org/packages/source/p/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "026aefd497c0426317d951f9a6e6f251"
SRC_URI[sha256sum] = "23ceae1f30238f7f57912422cf9baa43b7c80ed88fc14ec749986eef5f2d6007"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

# DEPENDS_default: python-pip

DEPENDS += " \
        python-pip \
        "

# RDEPENDS_default: 
RDEPENDS_${PN} += " \
        python-lxml \
        python-requests \
        python-cython \
        "
