DESCRIPTION = "Store and access your passwords safely"
HOMEPAGE = "https://pypi.python.org/pypi/keyring/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7a7126e068206290f3fe9f8d6c713ea6"

SRC_URI[md5sum] = "c9691de646eced3b15e888e5b410d6a1"
SRC_URI[sha256sum] = "9aeadd006a852b78f4b4ef7c7556c2774d2432bbef8ee538a3e9089ac8b11466"

inherit setuptools3 pypi

DEPENDS += " \
	python3-hgtools \
	python3-setuptools-scm-native \
	python3-toml-native \
"

RDEPENDS_${PN} = " \
	python3-logging \
	python3-importlib-metadata \
"
