DESCRIPTION = "Python Zaqar Client"
HOMEPAGE = "https://github.com/openstack/python-zaqarclient"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

DEPENDS += " \
        python-pip \
        python-pbr \
        "

RDEPENDS_${PN} +=" \
        python-pbr \
        python-requests \
        python-six \
        python-stevedore \
        python-jsonschema \
        python-oslo.i18n \
        python-keystoneclient \
	"

SRCNAME = "zaqarclient"
SRC_URI = "git://github.com/openstack/${BPN}.git;branch=master"

PV = "0.2.0+git${SRCPV}"
SRCREV = "c1a0ea98b6f0aad5764ce197172b41d3efc1e485"
S = "${WORKDIR}/git"

inherit setuptools
