DESCRIPTION = "CLI and python client library for OpenStack Neutron"
HOMEPAGE = "https://launchpad.net/neutron"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

RDEPENDS_${PN} +="python-cliff \
	python-httplib2 \
	python-iso8601 \
	python-prettytable \
	python-pyparsing \
	python-simplejson \
	"

PR = "r0"

SRC_URI = "git://github.com/openstack/python-neutronclient.git;branch=master"

PV="git${SRCPV}"
SRCREV="1598fc0f75503f8c357ac4b58f77edf6e0443a69"
S = "${WORKDIR}/git"

inherit setuptools
