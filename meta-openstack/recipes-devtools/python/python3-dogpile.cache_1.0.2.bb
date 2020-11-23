DESCRIPTION = "Python Dogpile Cache: A caching front-end based on the Dogpile lock"
HOMEPAGE = "https://pypi.python.org/pypi/dogpile.cache"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=46e560ef3e93a33b284504845ea6a11d"

SRC_URI[md5sum] = "a325ec142d690269573a872e24fc1cb6"
SRC_URI[sha256sum] = "64fda39d25b46486a4876417ca03a4af06f35bfadba9f59613f9b3d748aa21ef"

inherit setuptools3 pypi

RDEPENDS_${PN} += " \
	python3-decorator \
	python3-logging \
	python3-numbers \
	python3-stevedore \
"


