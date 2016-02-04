DESCRIPTION = "oslo.reports library"
HOMEPAGE = "https://wiki.openstack.org/wiki/Oslo"
SECTION = "devel/python"
LICENSE = "Apache-2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

PV = "0.6.0+git${SRCPV}"
SRCREV = "31d4a2d9881316f1d2d911a677c0b7556e5040b6"

SRCNAME = "oslo.reports"
SRC_URI = "git://github.com/openstack/${SRCNAME}.git"

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
        python-babel \
        python-psutil \
        python-oslo.i18n \
        python-oslo.utils \
        python-oslo.serialization \
        "
