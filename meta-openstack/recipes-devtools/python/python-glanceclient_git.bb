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

SRCREV = "13b25ff1fed908cfe7b4e719a97efd7121e3be96"
PV = "2.8.0+git${SRCPV}"

SRC_URI = "\
	git://github.com/openstack/${BPN}.git;branch=stable/pike \
	file://glance-api-check.sh \
	"

S = "${WORKDIR}/git"

inherit setuptools monitor rmargparse

FILES_${PN} += "${datadir}/${SRCNAME}"

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
    python-pbr-native \
    "

RDEPENDS_${PN} += " \
   gmp \
   bash \
   python-pbr \
   python-babel \
   python-prettytable \
   python-keystoneauth1 \
   python-requests \
   python-warlock \
   python-six \
   python-oslo.utils \
   python-oslo.i18n \
   python-wrapt \
   python-pyopenssl \
   "

MONITOR_CHECKS_${PN} += "\
	glance-api-check.sh \
"
