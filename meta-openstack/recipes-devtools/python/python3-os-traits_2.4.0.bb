DESCRIPTION = "OpenStack library containing standardized trait strings."
HOMEPAGE = "https://github.com/openstack/os-traits"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

SRC_URI[sha256sum] = "af1df9485a3119c2a6647639c8bb8bb852cb839ad9c12fa1d9e72f402c66af49"

inherit setuptools3 pypi

DEPENDS += " \
        python3-pbr \
        "

DEPENDS += " \
        python3-pbr-native \
	"

RDEPENDS:${PN} += " \
        python3-pbr \
        python3-six \
	"
