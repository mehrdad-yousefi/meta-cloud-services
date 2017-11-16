DESCRIPTION = "Build self-validating python objects using JSON schemas"
HOMEPAGE = "http://github.com/bcwaldon/warlock"
SECTION = "devel/python"
LICENSE = "Apache-2"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=3b83ef96387f14655fc854ddc3c6bd57"

DEPENDS += "python-jsonschema python-jsonpatch"

SRC_URI[md5sum] = "61cc809a3af2c76288f4dd26a003932d"
SRC_URI[sha256sum] = "d7403f728fce67ee2f22f3d7fa09c9de0bc95c3e7bcf6005b9c1962b77976a06"

inherit setuptools pypi

RDEPENDS_${PN} += " python-jsonschema python-jsonpatch"

