DESCRIPTION = "A messaging framework for Python"
HOMEPAGE = "http://kombu.readthedocs.org"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=daea7c168428449fbee05e644df929f4"

SRC_URI[md5sum] = "2fb2be9fec0e6514231bba23a3779439"
SRC_URI[sha256sum] = "4249d9dd9dbf1fcec471d1c2def20653c9310dd1a217272d77e4844f9d5273cb"

inherit setuptools pypi

FILES_${PN}-doc += "${datadir}/${SRCNAME}"

RDEPENDS_${PN} = " \
        python-amqp \
        "
