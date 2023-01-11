DESCRIPTION = "OpenStack Command-line Client"
HOMEPAGE = "https://github.com/openstack/python-openstackclient"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

SRC_URI = " \
        git://github.com/openstack/python-openstackclient.git;branch=stable/zed;protocol=https \
        "

PV = "6.0.0+git${SRCPV}"
SRCREV = "27b2496e03ceb95b56b3b1b68a57058fe90251b5"
S = "${WORKDIR}/git"

inherit setuptools3

DEPENDS += "\
        python3-pbr \
        "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python3-pbr-native \
	"

RDEPENDS:${PN} += " \
        python3-pbr \
        python3-six \
        python3-babel \
        python3-cliff \
        python3-keystoneauth1 \
        python3-openstacksdk \
        python3-osc-lib \
        python3-oslo.i18n \
        python3-oslo.utils \
        python-glanceclient \
        python3-keystoneclient \
        python-novaclient \
        python-cinderclient \
        "
