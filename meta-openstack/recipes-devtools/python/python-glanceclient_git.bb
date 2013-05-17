DESCRIPTION = "Client library for Glance built on the OpenStack Images API"
HOMEPAGE = "https://github.com/openstack/python-glanceclient"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"
DEPENDS = "gmp"

SRCREV = "741c15f9633f642aa2e52de10b8eb65d6a8c9ecb"
PV = "0.9.0+gitr${SRCREV}"
PR = "0"

SRC_URI = "git://github.com/openstack/${PN}.git;protocol=https"

S = "${WORKDIR}/git"

inherit setuptools

FILES_${PN} += "${datadir}/${SRCNAME}"

RDEPENDS_${PN} = "gmp \
   python-warlock \
   python-pyopenssl \
   python-prettytable \
   python-setuptools-git \
   "

