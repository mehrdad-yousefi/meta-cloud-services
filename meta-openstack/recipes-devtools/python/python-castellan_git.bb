DESCRIPTION = "Generic Key Manager interface for OpenStack"
HOMEPAGE = "https://github.com/openstack/castellan"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

SRCNAME = "castellan"

SRC_URI = "\
	git://git.openstack.org/openstack/${SRCNAME}.git;branch=master \
	"

PV="0.2.1+git${SRCPV}"
SRCREV="4fda4a749f3f908d58817c326676073aa6fcf62a"
S = "${WORKDIR}/git"

inherit setuptools

DEPENDS += " \
        python-pip \
        python-pbr \
        "

RDEPENDS_${PN} += " \
        python-pbr \
        python-babel \
        python-cryptography \
        python-oslo.config \
        python-oslo.context \
        python-oslo.log \
        python-oslo.policy \
        python-oslo.serialization \
        python-oslo.utils \
	"
