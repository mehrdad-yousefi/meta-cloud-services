DESCRIPTION = "CLI and python client library for OpenStack Quantum"
HOMEPAGE = "https://launchpad.net/quantum"
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

SRC_URI = "https://pypi.python.org/packages/source/p/${PN}/${PN}-${PV}.tar.gz"

SRC_URI[md5sum] = "d319be32c95aa6e0110db925d5c3cfc9"
SRC_URI[sha256sum] = "9c445a8a2fc751561e84e8633542bc8e77666cf8e4f01acce7cc8137acd43bee"

S = "${WORKDIR}/${PN}-${PV}"

inherit setuptools
