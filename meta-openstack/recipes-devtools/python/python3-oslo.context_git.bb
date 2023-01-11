DESCRIPTION = "Oslo Context Library"
HOMEPAGE = "https://launchpad.net/oslo"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

SRCNAME = "oslo.context"
SRC_URI = "git://github.com/openstack/${SRCNAME}.git;branch=stable/zed;protocol=https"

PV = "5.0.0+git${SRCPV}"
SRCREV = "f388eb981dacd3f363fb23fd70ac22c5eb35edf8"
S = "${WORKDIR}/git"

inherit setuptools3

DEPENDS += " \
        python3-pip \
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
        python3-debtcollector \
        python3-positional \
        "
