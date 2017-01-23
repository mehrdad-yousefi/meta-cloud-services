SUMMARY = "Oslo Policy library"
DESCRIPTION = "The Oslo Policy library provides support for RBAC policy enforcement across all OpenStack services."
HOMEPAGE = "https://github.com/openstack/oslo.policy"
SECTION = "devel/python"
LICENSE = "Apache-2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

PV = "1.14.0+git${SRCPV}"
SRCREV = "018c7475c9dd75da0f902bbe3ec5d01855fa50d6"

SRCNAME = "oslo.policy"
SRC_URI = "git://github.com/openstack/${SRCNAME}.git;branch=stable/newton"

S = "${WORKDIR}/git"

inherit setuptools

DEPENDS += " \
        python-pip \
        python-pbr \
"

RDEPENDS_${PN} += " \
        python-oslo.config \
        python-oslo.i18n \
        python-oslo.serialization \
        python-oslo.utils \
        python-six \
        python-pyyaml \
        python-requests \
"
