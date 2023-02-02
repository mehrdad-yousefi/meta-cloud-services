DESCRIPTION = "Neutron shared routines and utilities."
HOMEPAGE = "https://github.com/openstack/neutron-lib"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

SRC_URI = "\
	git://github.com/openstack/neutron-lib.git;branch=master;protocol=https \
	"

PV="3.1.0+git${SRCPV}"
SRCREV="e8f0d31d38d397f148191d89c3b83907c688b514"
S = "${WORKDIR}/git"

inherit setuptools3

DEPENDS += " \
        python3-pbr \
        "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python3-pbr-native \
	"

RDEPENDS:${PN} += " \
        python3-pbr \
        python3-sqlalchemy \
        python3-debtcollector \
        python3-stevedore \
        python3-oslo.concurrency \
        python3-oslo.config \
        python3-oslo.context \
        python3-oslo.db \
        python3-oslo.i18n \
        python3-oslo.log \
        python3-oslo.messaging \
        python3-oslo.policy \
        python3-oslo.service \
        python3-oslo.utils \
        "
