DESCRIPTION = "OpenStack Command-line Client"
HOMEPAGE = "https://github.com/openstack/python-openstackclient"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

SRC_URI = " \
        git://github.com/openstack/python-openstackclient.git;branch=stable/pike;protocol=https \
        "

PV = "3.12.0+git${SRCPV}"
SRCREV = "ff4abb7d19829efa0209cb67faf01011d9c841c5"
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
        python-cliff \
        python3-keystoneauth1 \
        python-openstacksdk \
        python-osc-lib \
        python3-oslo.i18n \
        python3-oslo.utils \
        python-glanceclient \
        python3-keystoneclient \
        python-novaclient \
        python-cinderclient \
        "
