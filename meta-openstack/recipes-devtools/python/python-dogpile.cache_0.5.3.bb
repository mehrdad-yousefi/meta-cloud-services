DESCRIPTION = "Python Dogpile Cache: A caching front-end based on the Dogpile lock"
HOMEPAGE = "https://pypi.python.org/pypi/dogpile.cache"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=db99dd669263339f22dfc735801942ad"

PR = "r0"
SRCNAME = "dogpile.cache"

SRC_URI = "https://pypi.python.org/packages/source/d/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "e178b84bafb8e2da0be939f38db60689"
SRC_URI[sha256sum] = "2fe8c1a329830a9ada865a69cc5ebb2c2e6f2dbda3a6d4dbf5155c7d5194344b"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools


