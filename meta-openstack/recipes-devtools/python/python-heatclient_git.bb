DESCRIPTION = "CLI and python client library for OpenStack Heat"
HOMEPAGE = "https://launchpad.net/heat"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

RDEPENDS_${PN} +="python-cliff \
	python-httplib2 \
	python-iso8601 \
	python-prettytable \
	python-pyparsing \
	python-simplejson \
	"

PR = "r0"

SRC_URI = "git://github.com/openstack/python-heatclient.git;branch=master"

PV="git${SRCPV}"
SRCREV="30032302f359985335d50e80abb03ba901143168"
S = "${WORKDIR}/git"

inherit setuptools
