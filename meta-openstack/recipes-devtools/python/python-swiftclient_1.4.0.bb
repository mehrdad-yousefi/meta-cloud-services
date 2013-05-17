DESCRIPTION = "Client library for OpenStack Object Storage API"
HOMEPAGE = "https://github.com/openstack/python-swiftclient"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

PR = "r0"

SRC_URI = "https://pypi.python.org/packages/source/p/${PN}/${PN}-${PV}.tar.gz"

SRC_URI[md5sum] = "3767442551361cffdbb3681e401cea52"
SRC_URI[sha256sum] = "95367a1db761cd71ac480cd4733a1cc55ef2afc2d48613142b8b89eac50cccc8"

inherit setuptools 

RDEPENDS_${PN} += "python-simplejson"