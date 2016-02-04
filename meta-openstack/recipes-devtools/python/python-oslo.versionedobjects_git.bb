DESCRIPTION = "oslo.versionedobjects library"
HOMEPAGE = "https://wiki.openstack.org/wiki/Oslo"
SECTION = "devel/python"
LICENSE = "Apache-2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

PV = "1.12.0+git${SRCPV}"
SRCREV = "9261f3ae3678cca8411ba1700e2ae18f3e5dfb9c"

SRCNAME = "oslo.versionedobjects"
SRC_URI = "git://github.com/openstack/${SRCNAME}.git"

S = "${WORKDIR}/git"

inherit setuptools

DEPENDS += " \
        python-pip \
        python-pbr \
        "

# RDEPENDS_default: 
RDEPENDS_${PN} += " \
        python-six \
        python-babel \
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
       "
