DESCRIPTION = "OpenStack Command-line Client"
HOMEPAGE = "https://github.com/openstack/python-openstackclient"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

PR = "r0"
SRCNAME = "python-openstackclient"

SRC_URI = "http://pypi.python.org/packages/source/p/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "e3c2b0ef8539a583f767427de8a4bdf9"
SRC_URI[sha256sum] = "ca8df0a256ed48536b386cde215a3532f98707eef8dba3343850ca80d29ce086"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
