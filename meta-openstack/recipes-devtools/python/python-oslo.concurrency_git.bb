DESCRIPTION = "oslo.concurrency library"
HOMEPAGE = "http://launchpad.net/oslo"
SECTION = "devel/python"
LICENSE = "Apache-2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

PV = "2.8.0+git${SRCPV}"
SRCREV = "28fb7e8bb0dfc39e9f5ed46ade65ea85048efc34"

SRCNAME = "oslo.concurrency"
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
        python-pbr \
        python-fasteners \
        python-babel \
        python-iso8601 \
        python-oslo.config \
        python-oslo.i18n \
        python-oslo.utils \
        python-six \
        python-retrying \
        python-enum34 \
        "
