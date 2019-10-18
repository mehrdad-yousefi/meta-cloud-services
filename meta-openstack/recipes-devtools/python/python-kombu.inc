DESCRIPTION = "A messaging framework for Python"
HOMEPAGE = "http://kombu.readthedocs.org"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=daea7c168428449fbee05e644df929f4"

SRC_URI[md5sum] = "6279c780cfa64beda3a303f54cb19a7a"
SRC_URI[sha256sum] = "c9078124ce2616b29cf6607f0ac3db894c59154252dee6392cdbbe15e5c4b566"

inherit pypi

FILES_${PN}-doc += "${datadir}/${SRCNAME}"

RDEPENDS_${PN} = " \
        ${PYTHON_PN}-amqp \
        "
