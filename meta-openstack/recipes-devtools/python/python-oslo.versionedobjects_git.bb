DESCRIPTION = "oslo.versionedobjects library"
HOMEPAGE = "https://wiki.openstack.org/wiki/Oslo"
SECTION = "devel/python"
LICENSE = "Apache-2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

PV = "1.17.0+git${SRCPV}"
SRCREV = "9f33bd4c74949ebe42bffe39c529aa6a1c94e531"

SRCNAME = "oslo.versionedobjects"
SRC_URI = "git://github.com/openstack/${SRCNAME}.git;branch=stable/newton"

S = "${WORKDIR}/git"

inherit setuptools

DEPENDS += " \
        python-pip \
        python-pbr \
        "

# RDEPENDS_default: 
RDEPENDS_${PN} += " \
        python-six \
        python-oslo.concurrency \
        python-oslo.config \
        python-oslo.context \
        python-oslo.messaging \
        python-oslo.serialization \
        python-oslo.utils \
        python-oslo.log \
        python-oslo.i18n \
        python-webob \
        python-iso8601 \
        python-netaddr \
       "
