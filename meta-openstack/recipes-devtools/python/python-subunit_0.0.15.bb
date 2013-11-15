DESCRIPTION = "Python implementation of subunit test streaming protocol"
HOMEPAGE = "https://pypi.python.org/pypi/python-subunit/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://README;md5=a6d86940a8393cf77ecc299eff036a1c"

PR = "r0"
SRCNAME = "python-subunit"

SRC_URI = "https://pypi.python.org/packages/source/p/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "65e43979f1156911a468fa76cc192c0a"
SRC_URI[sha256sum] = "3be52e3754e6033292851ea28745706fb5941d2f4f347833af46c0a895dba46d"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
