DESCRIPTION = "A messaging framework for Python"
HOMEPAGE = "http://kombu.readthedocs.org"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=daea7c168428449fbee05e644df929f4"

SRC_URI[md5sum] = "4eb5f1e6f669e04f5bd0c627c7467156"
SRC_URI[sha256sum] = "e5f0312dfb9011bebbf528ccaf118a6c2b5c3b8244451f08381fb23e7715809b"

inherit pypi

FILES_${PN}-doc += "${datadir}/${SRCNAME}"

RDEPENDS_${PN} = " \
        ${PYTHON_PN}-amqp \
        "
