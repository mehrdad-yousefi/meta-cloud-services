DESCRIPTION = "Python bindings to the OpenStack Manila API"
HOMEPAGE = "https://github.com/openstack/python-manilaclient"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9edbbf5857ab51214ef0e8b79069bb07"

DEPENDS += " \
        python-pip \
        python-pbr \
        "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python-pbr-native \
        "

RDEPENDS_${PN} +=" \
        python-pbr \
        python-iso8601 \
        python-oslo.config \
        python-oslo.log \
        python-oslo.serialization \
        python-oslo.utils \
        python-prettytable \
        python-pycrypto \
        python-requests \
        python-simplejson \
        python-babel \
        python-six \
        python-keystoneclient \
	"

SRCNAME = "manilaclient"
SRC_URI = "git://github.com/openstack/${BPN}.git;branch=master"

PV = "1.27.0+git${SRCPV}"
SRCREV = "07564879ae4bdcb73e856b3aedcb79e4420fa7eb"
S = "${WORKDIR}/git"

inherit setuptools rmargparse
