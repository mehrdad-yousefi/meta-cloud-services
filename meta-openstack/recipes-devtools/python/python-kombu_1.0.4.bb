DESCRIPTION = "A messaging framework for Python"
HOMEPAGE = "http://kombu.readthedocs.org"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=47f78a96b609f5bedd4b2114ba8f5da0"

PR = "r0"
SRCNAME = "kombu"

SRC_URI = "https://pypi.python.org/packages/source/k/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "9648a24738bf639a0625967236ebc40a"
SRC_URI[sha256sum] = "a876b9dd923e2d719afa7491e6d7a90829ebc9d836d8c4f71332984042693140"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

FILES_${PN}-doc += "${datadir}/${SRCNAME}"

RDEPENDS_${PN} = "python-anyjson python-amqplib"
