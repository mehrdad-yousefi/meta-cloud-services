DESCRIPTION = "oslo.i18n library"
HOMEPAGE = "http://launchpad.net/oslo"
SECTION = "devel/python"
LICENSE = "Apache-2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

PV = "3.20.0+git${SRCPV}"
SRCREV = "172e20b10981069c36b0f42377e5b4fbe22a9864"

SRCNAME = "oslo.i18n"
SRC_URI = "git://github.com/openstack/${SRCNAME}.git;branch=master"

S = "${WORKDIR}/git"

inherit setuptools

# DEPENDS_default: python-pip

DEPENDS += " \
        python-pip \
        python-pbr \
        "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python-pbr-native \
        "

# RDEPENDS_default: 
RDEPENDS_${PN} += " \
        python-babel \
        python-pbr \
        python-six \
        "
