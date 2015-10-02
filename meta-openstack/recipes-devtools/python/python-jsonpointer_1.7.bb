DESCRIPTION = "Identify specific nodes in a JSON document"
HOMEPAGE = "https://github.com/stefankoegl/python-json-pointer"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://jsonpointer.py;beginline=3;endline=31;md5=5e663c88967b53590856107a043d605c"

PR = "r0"
SRCNAME = "jsonpointer"

SRC_URI = "http://pypi.python.org/packages/source/j/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "97666849a7c390950a5ecfbeb74e64f4"
SRC_URI[sha256sum] = "46b2016b5e4f2b5cd2edf07c60ca8fe7dd91204ca848f98964be61b3c4760f5e"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
