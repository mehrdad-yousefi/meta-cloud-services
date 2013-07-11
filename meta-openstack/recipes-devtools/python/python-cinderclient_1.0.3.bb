DESCRIPTION = "Client library for OpenStack Cinder API."
HOMEPAGE = "https://github.com/openstack/python-cinderclient"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3572962e13e5e739b30b0864365e0795"
DEPENDS = "python-setuptools-git"

PR = "r0"
SRCNAME = "python-cinderclient"

SRC_URI = "http://pypi.python.org/packages/source/p/python-cinderclient/python-cinderclient-1.0.3.tar.gz"

SRC_URI[md5sum] = "3bf0b62be5fb293108899e49d709694c"
SRC_URI[sha256sum] = "6cc03f68a93a014d8ece1ed3bc7c37a6de79d08e29abfd97f185a5f412c7ce1a"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

RDEPENDS_${PN} += "python-prettytable \
	python-simplejson \
	python-requests \
    python-setuptools-git \
	"
