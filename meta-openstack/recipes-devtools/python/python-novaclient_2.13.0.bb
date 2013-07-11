DESCRIPTION = "Client library for OpenStack Compute API"
HOMEPAGE = "https://github.com/openstack/python-novaclient"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7cdb54622cacc9bc9b2883091e6dd669"
DEPENDS = "python-setuptools-git"

PR = "r0"

SRC_URI = "https://pypi.python.org/packages/source/p/${PN}/${PN}-${PV}.tar.gz"

SRC_URI[md5sum] = "e1079ade7e1956c8ea0613ca7910ab54"
SRC_URI[sha256sum] = "f48c9c159ea8efd617f0379d1df060ea53f40f40e29ebe733464779267a314e6"

inherit setuptools 

RDEPENDS_${PN} += "python-iso8601 \
	python-prettytable \
	python-requests \
	python-simplejson \
	"
