DESCRIPTION = "Generic Key Manager interface for OpenStack"
HOMEPAGE = "https://github.com/openstack/castellan"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

SRC_URI[sha256sum] = "66c8e02a822e78a8fd58abc928149c559f3d238472690f36e4993a9249b0636d"

inherit setuptools3 pypi

DEPENDS += " \
        python3-pip \
        python3-pbr \
        "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python3-pbr-native \
        "

RDEPENDS_${PN} += " \
        python3-pbr \
        python3-babel \
        python3-cryptography \
        python3-barbicanclient \
        python3-oslo.config \
        python3-oslo.context \
        python3-oslo.i18n \
        python3-oslo.log \
        python3-oslo.utils \
        python3-keystoneauth1 \
	bash \
        "
