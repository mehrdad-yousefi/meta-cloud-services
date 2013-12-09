DESCRIPTION = "Client library for OpenStack Compute API"
HOMEPAGE = "https://github.com/openstack/python-novaclient"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7cdb54622cacc9bc9b2883091e6dd669"
DEPENDS = "python-setuptools-git"

PR = "r0"

SRC_URI = "git://github.com/openstack/python-novaclient.git;branch=master"

PV="2.15.0+git${SRCPV}"
SRCREV="dd4bc08dd9a571637734a92c9411c32ea1f36dcf"
S = "${WORKDIR}/git"

inherit setuptools 

RDEPENDS_${PN} += "python-iso8601 \
	python-prettytable \
	python-requests \
	python-simplejson \
	"
