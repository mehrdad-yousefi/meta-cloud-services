DESCRIPTION = "Waitress WSGI server"
HOMEPAGE = "https://pypi.python.org/pypi/waitress/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=78ccb3640dc841e1baecb3e27a6966b2"

SRCNAME = "waitress"

SRC_URI = "https://pypi.python.org/packages/78/7d/84d11b96c3f60164dec3bef4a859a03aeae0231aa93f57fbe0d05fa4ff36/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "dda92358a7569669086155923a46e57c"
SRC_URI[sha256sum] = "2daacaece189ede6a23440afe03bda58089a6207f1d80a1e9497f979dfb741fc"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
