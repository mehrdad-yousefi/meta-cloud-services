DESCRIPTION = "A messaging framework for Python"
HOMEPAGE = "http://kombu.readthedocs.org"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=daea7c168428449fbee05e644df929f4"

SRC_URI[md5sum] = "0c98ce669cb7a05c5046ea6009c77cba"
SRC_URI[sha256sum] = "52763f41077e25fe7e2f17b8319d8a7b7ab953a888c49d9e4e0464fceb716896"

inherit setuptools pypi

FILES_${PN}-doc += "${datadir}/${SRCNAME}"

RDEPENDS_${PN} = " \
        python-amqp \
        "
