DESCRIPTION = "A robust and significantly extended implementation of JSONPath for Python"
HOMEPAGE = "https://github.com/kennknowles/python-jsonpath-rw"
SECTION = "devel/python"
LICENSE = "BSD+"
LIC_FILES_CHKSUM = "file://README.rst;md5=e3c17535d150260c7235db4e85145fa1"

PR = "r0"
SRCNAME = "jsonpath-rw"

SRC_URI = "http://pypi.python.org/packages/source/j/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "fe75b54ce4ea5201e132504590db6140"
SRC_URI[sha256sum] = "070f316dd172cdbb733f8da1b981ebcd3c8f90b75aca9f978c9ac145c1a25e86"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
