DESCRIPTION = "Client Library for OpenStack Datbase service"
HOMEPAGE = "https://github.com/openstack/python-troveclient"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

PR = "r0"

SRC_URI = "\
	git://github.com/openstack/python-troveclient.git;branch=master \
	"

PV="1.0.7+git${SRCPV}"
SRCREV="e010a919750f07493afd42a4db867853b925bcbf"
S = "${WORKDIR}/git"

inherit setuptools

DEPENDS += " \
        python-pip \
        python-pbr \
        "

RDEPENDS_${PN} += " \
        python-pbr \
        python-prettytable \
        python-requests \
        python-simplejson \
        python-babel \
        python-six \
	"
