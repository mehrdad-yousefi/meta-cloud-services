DESCRIPTION = "A Python re-implementation of the Rails routes system."
HOMEPAGE = "http://routes.groovie.org"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=151dabc4f4b91d0ac53e87d5326787fd"

SRCNAME = "Routes"

SRC_URI = "http://pypi.python.org/packages/source/R/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "e6e463318a9dc6ad2f1b3040e998f0b4"
SRC_URI[sha256sum] = "ebf4126e244cf11414653b5ba5f27ed4abfad38b906a01e5d4c93d3ce5568ea3"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools


