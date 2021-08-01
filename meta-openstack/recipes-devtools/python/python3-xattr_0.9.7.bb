DESCRIPTION = "Python wrapper for extended filesystem attributes"
HOMEPAGE = "http://github.com/xattr/xattr"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=7ebb582f22ddff5dcb0bc33d04f7cbb8"

SRC_URI[md5sum] = "3b9a928bc76c14eeeaccbc3c152c4920"
SRC_URI[sha256sum] = "b0bbca828e04ef2d484a6522ae7b3a7ccad5e43fa1c6f54d78e24bb870f49d44"

inherit setuptools3 pypi

DEPENDS += " \
	python3-cffi-native \
"

RDEPENDS:${PN} += " \
	python3-cffi \
"
