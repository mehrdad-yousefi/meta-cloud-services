DESCRIPTION = "Python bindings to the Designate API"
HOMEPAGE = "https://github.com/openstack/python-designateclient"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

DEPENDS += " \
        python-pip \
        python-pbr \
        "

RDEPENDS_${PN} +=" \
        python-cliff \
        python-jsonschema \
        python-oslo.utils \
        python-pbr \
        python-keystoneclient \
        python-requests \
        python-six \
        python-stevedore \
        python-debtcollector \
	"

SRCNAME = "designateclient"
SRC_URI = "git://github.com/openstack/${BPN}.git;branch=master"

PV = "1.5.0+git${SRCPV}"
SRCREV = "b97ae05612522180cc6f64485212811329da9645"
S = "${WORKDIR}/git"

inherit setuptools
