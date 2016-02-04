DESCRIPTION = "An oslo.config enabled dogpile.cache"
HOMEPAGE = "https://github.com/openstack/oslo.cache"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

PV = "0.7.0+git${SRCPV}"
SRCREV = "24f10af201da9264ba3db6eb2e8fcf583008d6b6"

SRCNAME = "oslo.cache"
SRC_URI = "git://github.com/openstack/${SRCNAME}.git"

S = "${WORKDIR}/git"

inherit setuptools

# DEPENDS_default: python-pip

DEPENDS += " \
        python-pip \
        python-pbr \
        "

# RDEPENDS_default: 
RDEPENDS_${PN} += " \
        python-babel \
        python-dogpile.cache \
        python-six \
        python-oslo.config \
        python-oslo.i18n \
        python-oslo.log \
        python-oslo.utils \
        python-memcached \
        python-pymongo \
        "
