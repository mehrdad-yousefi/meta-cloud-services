SUMMARY = "Extensions for JSONPath RW"
HOMEPAGE = "https://github.com/sileht/python-jsonpath-rw-ext"
SECTION = "devel/python"
LICENSE = "Apache-2.0"

LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

SRC_URI[sha256sum] = "a9e44e803b6d87d135b09d1e5af0db4d4cf97ba62711a80aa51c8c721980a994"

inherit pypi setuptools3

DEPENDS += " \
	python3-pbr \
	"

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python3-pbr-native \
        "

RDEPENDS_${PN} += " \
        python3-pbr \
        python3-babel \
        python3-jsonpath-rw \
        python3-six \
        python3-ply \
	"

