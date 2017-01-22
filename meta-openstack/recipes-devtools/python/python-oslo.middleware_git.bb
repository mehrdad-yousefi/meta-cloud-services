DESCRIPTION = "Oslo Middleware library"
HOMEPAGE = "http://launchpad.net/oslo"
SECTION = "devel/python"
LICENSE = "Apache-2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

PV = "3.19.0+git${SRCPV}"
SRCREV = "e3e052a92e9eb3e40af3c653281c944d34f822b4"

SRCNAME = "oslo.middleware"
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
        python-pbr \
        python-jinja2 \
        python-oslo.config \
        python-oslo.context \
        python-oslo.i18n \
        python-oslo.utils \
        python-six \
        python-stevedore \
        python-webob \
        python-debtcollector \
        "
