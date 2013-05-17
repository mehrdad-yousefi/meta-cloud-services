DESCRIPTION = "Build self-validating python objects using JSON schemas"
HOMEPAGE = "http://github.com/bcwaldon/warlock"
SECTION = "devel/python"
LICENSE = "Apache-2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

DEPENDS += "python-jsonschema python-jsonpatch"

PR = "0"
SRCNAME = "warlock"

SRC_URI = "http://pypi.python.org/packages/source/w/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "7567a1df0bbf76a113d945f307d93d9a"
SRC_URI[sha256sum] = "cc913fe3855f95512d183d158bd0a0f4e1c4b0619041ddb44fd15af8dc86e22a"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

RDEPENDS_${PN} += " python-jsonschema python-jsonpatch"

