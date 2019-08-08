DESCRIPTION = "A messaging framework for Python"
HOMEPAGE = "http://kombu.readthedocs.org"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=daea7c168428449fbee05e644df929f4"

SRC_URI[md5sum] = "adc9167ba3571c5465d6f7abe4945a12"
SRC_URI[sha256sum] = "eb365ea795cd7e629ba2f1f398e0c3ba354b91ef4de225ffdf6ab45fdfc7d581"

FILES_${PN}-doc += "${datadir}/${SRCNAME}"

RDEPENDS_${PN} = " \
        python-amqp \
        "
