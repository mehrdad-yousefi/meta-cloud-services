DESCRIPTION = "Glance's stores library"
HOMEPAGE = "https://github.com/openstack/glance_store"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

SRCREV = "c816b38d9f12be75d989409cbab6dfefa8f49dc3"
PV = "0.9.1+git${SRCPV}"

SRC_URI = "\
	git://github.com/openstack/glance_store.git;branch=master;protocol=https \
	"

S = "${WORKDIR}/git"

inherit setuptools3

DEPENDS += " \
        gmp \
        python3-pip \
        python3-pbr \
        "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python3-pbr-native \
        "

RDEPENDS:${PN} = " \
   python-enum34 \
   python-eventlet \
   python3-iso8601 \
   python3-six \
   python-cinderclient \
   python-oslo.config \
   python-oslo.i18n \
   python3-pbr \
   "

