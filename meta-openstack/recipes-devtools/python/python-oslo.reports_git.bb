DESCRIPTION = "oslo.reports library"
HOMEPAGE = "https://wiki.openstack.org/wiki/Oslo"
SECTION = "devel/python"
LICENSE = "Apache-2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

PV = "1.14.0+git${SRCPV}"
SRCREV = "2a9e24502d0960010c00314218ae85a1a04e71b2"

SRCNAME = "oslo.reports"
SRC_URI = "git://github.com/openstack/${SRCNAME}.git;branch=stable/newton"

S = "${WORKDIR}/git"

inherit setuptools

DEPENDS += " \
        python-pip \
        python-pbr \
        "

# RDEPENDS_default: 
RDEPENDS_${PN} += " \
        python-pbr \
        python-six \
        python-jinja2 \
        python-psutil \
        python-oslo.i18n \
        python-oslo.utils \
        python-oslo.serialization \
        "
