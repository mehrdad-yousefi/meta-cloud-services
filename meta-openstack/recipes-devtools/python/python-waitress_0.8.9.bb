DESCRIPTION = "Waitress WSGI server"
HOMEPAGE = "https://pypi.python.org/pypi/waitress/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=78ccb3640dc841e1baecb3e27a6966b2"

SRCNAME = "waitress"

SRC_URI = "https://pypi.python.org/packages/source/w/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "da3f2e62b3676be5dd630703a68e2a04"
SRC_URI[sha256sum] = "826527dc9d334ed4ed76cdae672fdcbbccf614186657db71679ab58df869458a"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
