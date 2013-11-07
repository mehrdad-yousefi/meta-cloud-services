DESCRIPTION = "Client library for OpenStack Compute API"
HOMEPAGE = "https://github.com/openstack/python-novaclient"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7cdb54622cacc9bc9b2883091e6dd669"
DEPENDS = "python-setuptools-git"

PR = "r0"

SRC_URI = "git://github.com/openstack/python-novaclient.git;branch=master"

PV="git${SRCPV}"
SRCREV="1d2263dae339590b60250793bc81ec5776845060"
S = "${WORKDIR}/git"

inherit setuptools 

RDEPENDS_${PN} += "python-iso8601 \
	python-prettytable \
	python-requests \
	python-simplejson \
	"
