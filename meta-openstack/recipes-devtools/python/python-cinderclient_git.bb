DESCRIPTION = "Client library for OpenStack Cinder API."
HOMEPAGE = "https://github.com/openstack/python-cinderclient"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3572962e13e5e739b30b0864365e0795"
DEPENDS = "python-setuptools-git"

PR = "r0"
SRCNAME = "python-cinderclient"

SRC_URI = "git://github.com/openstack/python-cinderclient.git;branch=master"

PV="1.0.7+git${SRCPV}"
SRCREV="8fc5ae480eafffc7e1bea046ad9b8e06350b008e"
S = "${WORKDIR}/git"

inherit setuptools

RDEPENDS_${PN} += "python-prettytable \
                   python-simplejson \
                   python-requests \
                   python-setuptools-git \
	           "
