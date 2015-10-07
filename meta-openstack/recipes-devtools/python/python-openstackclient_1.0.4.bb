DESCRIPTION = "OpenStack Command-line Client"
HOMEPAGE = "https://github.com/openstack/python-openstackclient"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRCNAME = "python-openstackclient"

SRC_URI = "http://pypi.python.org/packages/source/p/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "595c9be3ae2f967f7dd5f33753137377"
SRC_URI[sha256sum] = "d39a2e6cf98d409f8545b9d3a207eb8cbf3b2fc5ea17b0f8d9bed52326ca9f49"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

DEPENDS += "\
    python-pbr \
    "

RDEPENDS_${PN} += "\
    python-babel \
    python-cinderclient \
    python-cliff \
    python-cliff-tablib \
    python-glanceclient \
    python-keystoneclient \
    python-neutronclient \
    python-novaclient \
    python-oslo.config \
    python-oslo.i18n \
    python-oslo.serialization \
    python-oslo.utils \
    python-pbr \
    python-requests \
    python-six \
    python-stevedore \
    "
