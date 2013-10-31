DESCRIPTION = "CLI and python client library for OpenStack Ceilometer"
HOMEPAGE = "https://launchpad.net/ceilometer"
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

SRC_URI = "git://github.com/openstack/python-ceilometerclient.git;branch=master"

PV="git${SRCPV}"
SRCREV="067b76d9a821c3acb60d93787396d25b729a7421"
S = "${WORKDIR}/git"

inherit setuptools
