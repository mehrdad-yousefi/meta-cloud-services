DESCRIPTION = "A messaging framework for Python"
HOMEPAGE = "http://kombu.readthedocs.org"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=daea7c168428449fbee05e644df929f4"

SRC_URI[md5sum] = "3543525c1bfaa74260cbf9a6e47dad2f"
SRC_URI[sha256sum] = "27345bb569eb6bb583bca27dfc0ef181ca6c59c40c6e203cecaa0aeca84360be"

inherit setuptools pypi

FILES_${PN}-doc += "${datadir}/${SRCNAME}"

RDEPENDS_${PN} = " \
        python-amqp \
        "
