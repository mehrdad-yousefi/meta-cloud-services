DESCRIPTION = "An oslo.config enabled dogpile.cache"
HOMEPAGE = "https://github.com/openstack/oslo.cache"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

PV = "1.14.0+git${SRCPV}"
SRCREV = "ff5bbb96d73a83c1e25759c42a30f01608de5b8a"

SRCNAME = "oslo.cache"
SRC_URI = "git://github.com/openstack/${SRCNAME}.git;branch=stable/newton"

S = "${WORKDIR}/git"

inherit setuptools

# DEPENDS_default: python-pip

DEPENDS += " \
        python-pip \
        python-pbr \
        "

# RDEPENDS_default: 
RDEPENDS_${PN} += " \
        python-dogpile.cache \
        python-six \
        python-oslo.config \
        python-oslo.i18n \
        python-oslo.log \
        python-oslo.utils \
        "
