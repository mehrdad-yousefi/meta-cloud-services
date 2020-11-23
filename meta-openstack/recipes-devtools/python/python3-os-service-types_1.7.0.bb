DESCRIPTION = "Python library for consuming OpenStack sevice-types-authority data"
HOMEPAGE = "https://pypi.org/project/os-service-types/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

SRC_URI[sha256sum] = "31800299a82239363995b91f1ebf9106ac7758542a1e4ef6dc737a5932878c6c"

inherit setuptools3 pypi

DEPENDS += " \
	python3-pbr-native \
        "

RDEPENDS_${PN} += " \
	python3-pbr \
	"
