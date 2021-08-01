DESCRIPTION = "Testresources, a pyunit extension for managing expensive test resources"
HOMEPAGE = "https://pypi.python.org/pypi/testtools/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=eb75e5ad7c7ff3315ffafae1403e94b2"

SRC_URI[md5sum] = "8873ab443db5569528964f524228a2d7"
SRC_URI[sha256sum] = "ee9d1982154a1e212d4e4bac6b610800bfb558e4fb853572a827bc14a96e4417"

inherit setuptools3 pypi

DEPENDS += " \
	python3-pbr-native \
"

RDEPENDS:${PN} += " \
	python3-unittest \
	python3-pbr \
"
