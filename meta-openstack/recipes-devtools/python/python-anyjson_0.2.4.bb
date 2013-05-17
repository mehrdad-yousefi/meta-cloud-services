DESCRIPTION = "Loads the best available JSON implementation available in a common interface"
HOMEPAGE = "https://bitbucket.org/runeh/anyjson"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=989aa97e73c912a83a3c873fa11deb08"

PR = "r0"
SRCNAME = "anyjson"

SRC_URI = "http://pypi.python.org/packages/source/a/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

SRC_URI[md5sum] = "ed707033ad6cee0a44db199c289a4c80"
SRC_URI[sha256sum] = "27ddec5bc9220c13f405cb30adee9b5db17a608f56935618785219348c8a90ac"

RDEPENDS_${PN} = "python-simplejson"
