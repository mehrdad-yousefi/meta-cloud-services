DESCRIPTION = "Load, configure, and compose WSGI applications and servers"
HOMEPAGE = "http://pythonpaste.org/deploy/"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://docs/license.txt;md5=1798f29d55080c60365e6283cb49779c"

PR = "r0"
SRCNAME = "PasteDeploy"

SRC_URI = "https://pypi.python.org/packages/source/P/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "f1a068a0b680493b6eaff3dd7690690f"
SRC_URI[sha256sum] = "61c205633adae996cd0e306451c8a28deca0499524e2a38c65ff1570f35a8a53"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

RDEPENDS_${PN} += "python-paste"
