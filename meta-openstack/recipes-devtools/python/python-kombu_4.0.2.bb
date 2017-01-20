DESCRIPTION = "A messaging framework for Python"
HOMEPAGE = "http://kombu.readthedocs.org"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=daea7c168428449fbee05e644df929f4"

SRCNAME = "kombu"

SRC_URI = "https://pypi.python.org/packages/c7/76/58c655a80bf08b703478ce673ed4e3029297105951863b73030d45b06b42/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "1f24f3a8addf8f3eb0f463aad970f0fb"
SRC_URI[sha256sum] = "d0fc6f2a36610a308f838db4b832dad79a681b516ac1d1a1f9d42edb58cc11a2"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

FILES_${PN}-doc += "${datadir}/${SRCNAME}"

RDEPENDS_${PN} = "python-anyjson python-amqplib"
