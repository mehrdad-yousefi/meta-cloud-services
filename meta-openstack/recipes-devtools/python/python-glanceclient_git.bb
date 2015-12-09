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

SRCREV = "db6420b44779411d6d1f238f6b887f83f1988986"
PV = "0.19.0+git${SRCPV}"
PR = "r0"

SRC_URI = "\
	git://github.com/openstack/${BPN}.git;protocol=https \
	file://fix_glanceclient_memory_leak.patch \
	file://glance-api-check.sh \
	"

S = "${WORKDIR}/git"

inherit setuptools monitor rmargparse

FILES_${PN} += "${datadir}/${SRCNAME}"

RDEPENDS_${PN} = "gmp \
   python-warlock \
   python-pyopenssl \
   python-prettytable \
   python-setuptools-git \
   python-pbr \
   bash \
   "

MONITOR_CHECKS_${PN} += "\
	glance-api-check.sh \
"
