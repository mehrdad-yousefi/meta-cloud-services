DESCRIPTION = "Classes and setuptools plugin for Mercurial repositories"
HOMEPAGE = "https://pypi.python.org/pypi/hgtools"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7a7126e068206290f3fe9f8d6c713ea6"

SRC_URI[md5sum] = "5234d6ea4987f1ccdd1aa87235550c81"
SRC_URI[sha256sum] = "6d0aa3eb4b73e937d6e1f928a011911621b54a95cee8d999839362039dfe8d4b"

DEPENDS += " \
	python3-setuptools-scm-native \
	python3-toml-native \
"

inherit setuptools3 pypi

