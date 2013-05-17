DESCRIPTION = "An implementation of JSON-Schema validation for Python"
HOMEPAGE = "http://pypi.python.org/pypi/jsonschema"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=833b6ec380e7cdfcdab8ea6138da2e34"

PR = "0"
SRCNAME = "jsonschema"

SRC_URI = "http://pypi.python.org/packages/source/j/${SRCNAME}/${SRCNAME}-${PV}.zip"

SRC_URI[md5sum] = "b93f9bd7864d7c5c587951efa4c0a80f"
SRC_URI[sha256sum] = "703b92b969d245b060b37055305110539507dfdc64ac1760b1868ca489c121e0"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils
