DESCRIPTION = "CLI and python client library for OpenStack Sahara"
HOMEPAGE = "https://launchpad.net/sahara"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

DEPENDS += " \
        python-pip \
        python-pbr \
        "

RDEPENDS_${PN} += " \
	python-pbr \
	"

SRCNAME = "saharaclient"

SRC_URI = "git://github.com/openstack/python-saharaclient.git;branch=master"

PV="0.7.0+git${SRCPV}"
SRCREV="6531965b9719e4ea3a9986afa16daaf12fbba516"
S = "${WORKDIR}/git"

inherit setuptools

