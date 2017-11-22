DESCRIPTION = "Python bindings to the Designate API"
HOMEPAGE = "https://github.com/openstack/python-designateclient"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

DEPENDS += " \
        python-pip \
        python-pbr \
        "

RDEPENDS_${PN} += " \
        python-cliff \
        python-jsonschema \
        python-osc-lib \
        python-oslo.utils \
        python-pbr \
        python-keystoneauth1 \
        python-requests \
        python-six \
        python-stevedore \
        python-debtcollector \
        "

SRCNAME = "designateclient"
SRC_URI = "git://github.com/openstack/${BPN}.git;branch=stable/pike"

PV = "2.7.0+git${SRCPV}"
SRCREV = "77a705857f2c303a03fdbccd4460a68b61d92fd0"
S = "${WORKDIR}/git"

inherit setuptools
