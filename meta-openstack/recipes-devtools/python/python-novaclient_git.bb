DESCRIPTION = "Client library for OpenStack Compute API"
HOMEPAGE = "https://github.com/openstack/python-novaclient"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7cdb54622cacc9bc9b2883091e6dd669"
DEPENDS = "python-setuptools-git"

PR = "r0"

SRC_URI = "\
	git://github.com/openstack/python-novaclient.git;branch=master \
	file://fix_novaclient_memory_leak.patch \
	"

PV="2.16.0+git${SRCPV}"
SRCREV="64043442bbafa48f9042b669d30292b1db00db4f"
S = "${WORKDIR}/git"

inherit setuptools 

DEPENDS += " \
        python-pip \
        python-pbr \
        "

RDEPENDS_${PN} += "python-iso8601 \
	python-prettytable \
	python-requests \
	python-simplejson \
	python-pbr \
	"
