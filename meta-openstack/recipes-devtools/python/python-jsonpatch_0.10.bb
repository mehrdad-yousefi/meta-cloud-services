DESCRIPTION = "An implementation of the JSON Patch format"
HOMEPAGE = "https://github.com/stefankoegl/python-json-patch"
SECTION = "devel/python"
LICENSE = "BSD+"
LIC_FILES_CHKSUM = "file://jsonpatch.py;beginline=3;endline=30;md5=5cd7d1fbd6b236ed142e4285624f58fe"

PR = "0"
SRCNAME = "jsonpatch"

SRC_URI = "http://pypi.python.org/packages/source/j/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "d9a96bdfe208c42415b1749f1b591fa7"
SRC_URI[sha256sum] = "86409f5c0a8392a277488dd11fc0f603e7241c95cf547b7048e30e69b7f74107"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

RDEPENDS_${PN} += "python-jsonpointer"
