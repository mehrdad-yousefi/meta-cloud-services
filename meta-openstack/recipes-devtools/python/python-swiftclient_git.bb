DESCRIPTION = "Client library for OpenStack Object Storage API"
HOMEPAGE = "https://github.com/openstack/python-swiftclient"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

PR = "r0"

SRC_URI = "git://github.com/openstack/python-swiftclient.git;branch=master"

PV="1.8.0+git${SRCPV}"
SRCREV="4b78b4d136f5e18544ba97db85f47c5201d3a761"
S = "${WORKDIR}/git"

inherit setuptools 

RDEPENDS_${PN} += "python-simplejson"