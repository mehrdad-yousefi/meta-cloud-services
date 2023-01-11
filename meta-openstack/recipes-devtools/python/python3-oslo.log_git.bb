DESCRIPTION = "Oslo Log Library"
HOMEPAGE = "https://launchpad.net/oslo"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

SRCNAME = "oslo.log"
SRC_URI = "git://github.com/openstack/${SRCNAME}.git;branch=master;protocol=https"

PV = "5.0.2+git${SRCPV}"
SRCREV = "de615d9370681a2834cebe88acfa81b919da340c"
S = "${WORKDIR}/git"

inherit setuptools3

DEPENDS += " \
        python3-pip \
        python3-babel \
        python3-pbr \
        "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python3-pbr-native \
        "

# RDEPENDS:default: 
RDEPENDS:${PN} += " \
        bash \
        python3-pbr \
        python3-six \
        python3-oslo.config \
        python3-oslo.context \
        python3-oslo.i18n \
        python3-oslo.utils \
        python3-oslo.serialization \
        python3-pyinotify \
        python3-debtcollector \
        python3-dateutil \
        python3-monotonic \
        "
