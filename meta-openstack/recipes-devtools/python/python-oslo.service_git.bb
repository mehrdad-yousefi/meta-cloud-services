DESCRIPTION = "oslo.service library"
HOMEPAGE = "https://wiki.openstack.org/wiki/Oslo"
SECTION = "devel/python"
LICENSE = "Apache-2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

PV = "0.16.0"
SRCREV = "e11a2880777249674664ec330004fda5e605ac73"

SRCNAME = "oslo.service"
SRC_URI = "git://github.com/openstack/${SRCNAME}.git;branch=stable/newton"

S = "${WORKDIR}/git"

inherit setuptools

DEPENDS += " \
        python-pip \
        python-pbr \
        "

RDEPENDS_${PN} += " \
        python-pbr \
        python-webob \
        python-eventlet \
        python-greenlet \
        python-monotonic \
        python-oslo.utils \
        python-oslo.concurrency \
        python-oslo.config \
        python-oslo.log \
        python-six \
        python-oslo.i18n \
        python-pastedeploy \
        python-paste \
        python-routes \
        "
