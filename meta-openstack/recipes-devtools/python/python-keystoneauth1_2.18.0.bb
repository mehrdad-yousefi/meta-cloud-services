DESCRIPTION = "Authentication Library for OpenStack Identity"
HOMEPAGE = "https://pypi.python.org/pypi/keystoneauth1"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=96f840d59b245a1c817fbcb901afc574"

SRCNAME = "keystoneauth1"
SRC_URI = "http://pypi.io/packages/source/k/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "d24c08bc7d59081adce160444ebc6993"
SRC_URI[sha256sum] = "075a9ca7a8877c5885fa2487699015e45260c4e6be119683effe0ad2ab1255d2"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

DEPENDS += " \
        python-pbr \
        "

RDEPENDS_${PN} += " \
        python-pbr \
        python-iso8601 \
        python-positional \
        python-requests \
        python-six \
        python-stevedore \
        "
