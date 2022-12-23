DESCRIPTION = "Neutron shared routines and utilities."
HOMEPAGE = "https://github.com/openstack/neutron-lib"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

SRC_URI = "\
	git://git.openstack.org/openstack/neutron-lib.git;branch=stable/pike \
	"

PV="1.9.1+git${SRCPV}"
SRCREV="f0d7e470c2ef1702b2715ceb2fd8a00fce2a23be"
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
        python-debtcollector \
        python-stevedore \
        python3-oslo.concurrency \
        python-oslo.config \
        python3-oslo.context \
        python-oslo.db \
        python3-oslo.i18n \
        python-oslo.log \
        python-oslo.messaging \
        python-oslo.policy \
        python3-oslo.service \
        python3-oslo.utils \
        "
