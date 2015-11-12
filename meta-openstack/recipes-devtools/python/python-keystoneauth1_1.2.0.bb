DESCRIPTION = "Authentication Library for OpenStack Identity"
HOMEPAGE = "https://pypi.python.org/pypi/keystoneauth1"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=96f840d59b245a1c817fbcb901afc574"

SRCNAME = "keystoneauth1"
SRC_URI = "http://pypi.python.org/packages/source/k/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "db4c75346480300fe9015945f73ab33a"
SRC_URI[sha256sum] = "e8386dc8b0f17d439e1f2f4e6a8ef64fe0f2b81938b2f0b13f80042bb98e2b85"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

DEPENDS += " \
        python-pbr \
        "

RDEPENDS_${PN} += " \
        python-pbr \
        "
