DESCRIPTION = "Glance's stores library"
HOMEPAGE = "https://github.com/openstack/glance_store"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

SRCREV = "32d5baa37d1efe1f5372d0171c7edcd719885db6"
PV = "0.1.7+git${SRCPV}"

SRC_URI = "\
	git://github.com/openstack/glance_store.git \
	"

S = "${WORKDIR}/git"

inherit setuptools

DEPENDS += " \
        gmp \
        python-pip \
        python-pbr \
        "

RDEPENDS_${PN} = " \
   python-eventlet \
   python-iso8601 \
   python-six \
   python-cinderclient \
   python-oslo.config \
   python-oslo.i18n \
   "

