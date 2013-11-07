DESCRIPTION = "Build self-validating python objects using JSON schemas"
HOMEPAGE = "http://github.com/bcwaldon/warlock"
SECTION = "devel/python"
LICENSE = "Apache-2"
LIC_FILES_CHKSUM = "file://README.md;md5=97b002bcda83d22e7d3fd1427688a6a6"

DEPENDS += "python-jsonschema python-jsonpatch"

PR = "0"
SRCNAME = "warlock"

SRC_URI = "http://pypi.python.org/packages/source/w/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "a0096d4843da1f939c873460b53c02e0"
SRC_URI[sha256sum] = "986ccfd647f89c1c8e7ebe40d159e5633818a58754b3ffdf51c4816927977791"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

RDEPENDS_${PN} += " python-jsonschema python-jsonpatch"

