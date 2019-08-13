DESCRIPTION = "Python Zaqar Client"
HOMEPAGE = "https://github.com/openstack/python-zaqarclient"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

DEPENDS += " \
        python-pip \
        python-pbr \
        "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python-pbr-native \
        "

RDEPENDS_${PN} +=" \
        python-pbr \
        python-requests \
        python-six \
        python-stevedore \
        python-jsonschema \
        python-oslo.i18n \
        python-oslo.log \
        python-oslo.utils \
        python-keystoneauth1 \
        python-osc-lib \
	"
	
SRCNAME = "zaqarclient"
SRC_URI = "git://github.com/openstack/${BPN}.git"

PV = "1.11.0+git${SRCPV}"
SRCREV = "13e90a0ab5e296fb8cf21d09c666c06ed47a84c0"
S = "${WORKDIR}/git"

inherit setuptools
