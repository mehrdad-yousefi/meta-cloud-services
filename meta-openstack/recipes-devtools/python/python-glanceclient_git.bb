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

SRCREV = "26280ed58b5d16feed4ab27be063d305ef48a252"
PV = "0.17.0+git${SRCPV}"
PR = "r0"

SRC_URI = "\
	git://github.com/openstack/${BPN}.git;protocol=https \
	file://fix_glanceclient_memory_leak.patch \
	file://glance-api-check.sh \
	"

S = "${WORKDIR}/git"

inherit setuptools monitor

FILES_${PN} += "${datadir}/${SRCNAME}"

DEPENDS += " \
   python-pbr \
   "

RDEPENDS_${PN} = "gmp \
   python-warlock \
   python-pyopenssl \
   python-prettytable \
   python-setuptools-git \
   python-pbr \
   "

MONITOR_CHECKS_${PN} += "\
	glance-api-check.sh \
"
