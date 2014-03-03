DESCRIPTION = "Client library for OpenStack Identity API"
HOMEPAGE = "https://github.com/openstack/python-keystoneclient"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4a4d0e932ffae1c0131528d30d419c55"

PR = "r0"

SRC_URI = "git://github.com/openstack/python-keystoneclient.git;branch=master"

PV="0.6.0+git${SRCPV}"
SRCREV="a6b8e506740935498f5eba319c67b740d17752a2"
S = "${WORKDIR}/git"

inherit setuptools

FILES_${PN}-doc += "${datadir}/keystoneclient" 

RDEPENDS_${PN} += "python-iso8601 \
	python-prettytable \
	python-requests \
	python-simplejson \
	python-oslo.config \
	"
