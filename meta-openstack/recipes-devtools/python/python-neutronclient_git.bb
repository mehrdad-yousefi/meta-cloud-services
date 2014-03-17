DESCRIPTION = "CLI and python client library for OpenStack Neutron"
HOMEPAGE = "https://launchpad.net/neutron"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

DEPENDS += " \
        python-pip \
        python-pbr \
        "

RDEPENDS_${PN} +="python-cliff \
	python-httplib2 \
	python-iso8601 \
	python-prettytable \
	python-pyparsing \
	python-simplejson \
	python-pbr \
	"

PR = "r0"

SRC_URI = "git://github.com/openstack/python-neutronclient.git;branch=master"

PV="2.3.4+git${SRCPV}"
SRCREV="6adb11703cb5b55a4af45e8524dc1039fb03176c"
S = "${WORKDIR}/git"

inherit setuptools
