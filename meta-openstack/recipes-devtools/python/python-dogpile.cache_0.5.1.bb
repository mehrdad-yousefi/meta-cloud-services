DESCRIPTION = "Python Dogpile Cache: A caching front-end based on the Dogpile lock"
HOMEPAGE = "https://pypi.python.org/pypi/dogpile.cache"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0401fd56584d7b3d4be91690672ec433"

PR = "r0"
SRCNAME = "dogpile.cache"

SRC_URI = "https://pypi.python.org/packages/source/d/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "604872aa7036ffc205c14160b5e83f99"
SRC_URI[sha256sum] = "1f3165222bc23418cb9d3f1a2c9d554a091f412e5bc871ea0c48a19b576d06c0"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools


