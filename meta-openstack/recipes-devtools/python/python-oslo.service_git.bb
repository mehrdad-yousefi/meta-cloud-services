DESCRIPTION = "oslo.service library"
HOMEPAGE = "https://wiki.openstack.org/wiki/Oslo"
SECTION = "devel/python"
LICENSE = "Apache-2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

PV = "0.11.0"
SRCREV = "3336127916edcd1d94f9bb2df978facb434efa5e"

SRCNAME = "oslo.service"
SRC_URI = "git://github.com/openstack/${SRCNAME}.git"

S = "${WORKDIR}/git"

inherit setuptools

DEPENDS += " \
        python-pip \
        python-pbr \
        "

RDEPENDS_${PN} += " \
        python-pbr \
        python-babel \
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
