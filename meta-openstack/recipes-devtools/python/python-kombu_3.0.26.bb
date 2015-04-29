DESCRIPTION = "A messaging framework for Python"
HOMEPAGE = "http://kombu.readthedocs.org"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a25a2e176842f3a9934f9d7ee8e0edae"

SRCNAME = "kombu"

SRC_URI = "https://pypi.python.org/packages/source/k/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "dda05763cd4b72a131fe1ef9ba93d542"
SRC_URI[sha256sum] = "1f565abd44c4b7dfaa4dd543d52f982d2f006aba0a2b3830542b4d25a801fe09"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

FILES_${PN}-doc += "${datadir}/${SRCNAME}"

RDEPENDS_${PN} = "python-anyjson python-amqplib"
