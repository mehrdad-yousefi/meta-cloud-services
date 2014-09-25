DESCRIPTION = "Client library for Glance built on the OpenStack Images API"
HOMEPAGE = "https://github.com/openstack/python-glanceclient"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"
DEPENDS += " \
        gmp \
        python-pip \
        python-pbr \
        "

SRCREV = "3c16d23293e5ee977c0a62e012e83c1247844255"
PV = "0.12.0+git${SRCPV}"
PR = "r0"

SRC_URI = "\
	git://github.com/openstack/${BPN}.git;protocol=https \
	file://fix_glanceclient_memory_leak.patch \
	"

S = "${WORKDIR}/git"

inherit setuptools

FILES_${PN} += "${datadir}/${SRCNAME}"

RDEPENDS_${PN} = "gmp \
   python-warlock \
   python-pyopenssl \
   python-prettytable \
   python-setuptools-git \
   python-pbr \
   "

