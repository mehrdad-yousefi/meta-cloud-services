DESCRIPTION = "Identify specific nodes in a JSON document"
HOMEPAGE = "https://github.com/stefankoegl/python-json-pointer"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://jsonpointer.py;beginline=3;endline=31;md5=5e663c88967b53590856107a043d605c"

PR = "0"
SRCNAME = "jsonpointer"

SRC_URI = "http://pypi.python.org/packages/source/j/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "41fe4189279b9c6cd35a4131cb2498f2"
SRC_URI[sha256sum] = "6a27fb4cb590a118d0f8c7e367f902cf553abf5dcb4b7938cdc91cc36e3e4bdf"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils
