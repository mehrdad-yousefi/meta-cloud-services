DESCRIPTION = "An implementation of the JSON Patch format"
HOMEPAGE = "https://github.com/stefankoegl/python-json-patch"
SECTION = "devel/python"
LICENSE = "BSD+"
LIC_FILES_CHKSUM = "file://jsonpatch.py;beginline=3;endline=30;md5=5cd7d1fbd6b236ed142e4285624f58fe"

PR = "r0"
SRCNAME = "jsonpatch"

SRC_URI = "http://pypi.python.org/packages/source/j/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "5eee76359052a1c289cf61eaf037332d"
SRC_URI[sha256sum] = "e997076450992aa7af2f4ae6c3e7767d390ddb6746979c74fd2092bb8fbdf5b2"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

RDEPENDS_${PN} += "python-jsonpointer"
