DESCRIPTION = "Python Dogpile Cache: A caching front-end based on the Dogpile lock"
HOMEPAGE = "https://pypi.python.org/pypi/dogpile.cache"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=46e560ef3e93a33b284504845ea6a11d"

SRC_URI[md5sum] = "3cf83a593a1a1bc17b89d14917f66ef0"
SRC_URI[sha256sum] = "40147b19696f387415a7efaaa4cf8ea0b5d31bdd1b53e5187e75d48ddfee9f0e"

inherit setuptools3 pypi

RDEPENDS_${PN} += " \
	python3-decorator \
	python3-logging \
	python3-numbers \
	python3-stevedore \
"


