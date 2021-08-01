DESCRIPTION = "munch is a fork of David Schoonover's Bunch package, providing similar functionality"
HOMEPAGE = "https://pypi.org/project/munch/"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=f0291cd32b2d6a91d9b19970c94d0a46"

SRC_URI[md5sum] = "ed84c3718416c8d4d03d0a6ef46e8e0c"
SRC_URI[sha256sum] = "2d735f6f24d4dba3417fa448cae40c6e896ec1fdab6cdb5e6510999758a4dbd2"

inherit setuptools3 pypi

DEPENDS += " \
	python3-pbr-native \
"

RDEPENDS:${PN} += " \
	python3-pkg-resources \
	python3-six \
"
