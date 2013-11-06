DESCRIPTION = "Identify specific nodes in a JSON document"
HOMEPAGE = "https://github.com/stefankoegl/python-json-pointer"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://jsonpointer.py;beginline=3;endline=31;md5=5e663c88967b53590856107a043d605c"

PR = "0"
SRCNAME = "jsonpointer"

SRC_URI = "http://pypi.python.org/packages/source/j/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

RC_URI[md5sum] = "51f0959e633b533057e9eb8cc508e468"
SRC_URI[sha256sum] = "a0fe333840d5191f14592ce9fc791bae57546564680a1aef5657edf88f29c366"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils
