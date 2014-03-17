DESCRIPTION = "Client library for OpenStack Object Storage API"
HOMEPAGE = "https://github.com/openstack/python-swiftclient"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

PR = "r0"

SRC_URI = "git://github.com/openstack/python-swiftclient.git;branch=master"

PV="2.0.2+git${SRCPV}"
SRCREV="3d35a3e989a180b3785b4f259a03c09eed32a14d"
S = "${WORKDIR}/git"

inherit setuptools 

DEPENDS += " \
        python-pip \
        python-pbr \
        "

RDEPENDS_${PN} += " \
        python-simplejson \
        python-pbr \
        "
