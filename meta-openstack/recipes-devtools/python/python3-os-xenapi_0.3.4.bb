DESCRIPTION = "XenAPI library for OpenStack projects."
HOMEPAGE = "https://github.com/openstack/os-xenapi"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

SRC_URI[sha256sum] = "85d9d4bff4086a9c36eb9b2b9dfce542fa8336821a63826180dc0e8637e8ad72"

inherit setuptools3 pypi

DEPENDS += " \
        python3-pbr \
        "

DEPENDS += " \
        python3-pbr-native \
	"
	
RDEPENDS_${PN} += " \
	bash \
        python3-pbr \
        python3-babel \
        python3-eventlet \
        python3-oslo.concurrency \
        python3-oslo.log \
        python3-oslo.utils \
        python3-oslo.i18n \
        python3-six \
        "
