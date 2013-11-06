DESCRIPTION = "An implementation of the JSON Patch format"
HOMEPAGE = "https://github.com/stefankoegl/python-json-patch"
SECTION = "devel/python"
LICENSE = "BSD+"
LIC_FILES_CHKSUM = "file://jsonpatch.py;beginline=3;endline=30;md5=5cd7d1fbd6b236ed142e4285624f58fe"

PR = "0"
SRCNAME = "jsonpatch"

SRC_URI = "http://pypi.python.org/packages/source/j/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "d3485ea3bb242656b4d8f167baccfbf2"
SRC_URI[sha256sum] = "a937c97325aa81ed6e326bd7c34f87f932b6c08ab89549e83c3d9098637d0390"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

RDEPENDS_${PN} += "python-jsonpointer"
