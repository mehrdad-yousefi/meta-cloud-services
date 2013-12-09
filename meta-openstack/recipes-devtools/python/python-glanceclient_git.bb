DESCRIPTION = "Client library for Glance built on the OpenStack Images API"
HOMEPAGE = "https://github.com/openstack/python-glanceclient"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"
DEPENDS = "gmp"

SRCREV = "cd7f2cbd79df54ea41d9a075d904efc82bdcb440"
PV = "0.12.0+gitr${SRCREV}"
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

