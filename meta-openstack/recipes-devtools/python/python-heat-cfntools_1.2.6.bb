DESCRIPTION = "Tools required to be installed on Heat provisioned cloud instances"
HOMEPAGE = "https://github.com/openstack/heat-cfntools"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

PR = "r0"
SRCNAME = "heat-cfntools"

SRC_URI = "http://pypi.python.org/packages/source/h/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "db19fcae40b8f9de6ec8251bdb50ac3c"
SRC_URI[sha256sum] = "da4a24908dd4b118b227252dba972a9b9b054bcc1002d4656b0e146747916f40"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
