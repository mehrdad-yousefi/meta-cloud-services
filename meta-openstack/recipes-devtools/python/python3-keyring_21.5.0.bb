DESCRIPTION = "Store and access your passwords safely"
HOMEPAGE = "https://pypi.python.org/pypi/keyring/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7a7126e068206290f3fe9f8d6c713ea6"

SRC_URI[md5sum] = "1609e4804bfc08ca0adf43f9d9c90de6"
SRC_URI[sha256sum] = "207bd66f2a9881c835dad653da04e196c678bf104f8252141d2d3c4f31051579"

inherit setuptools3 pypi

DEPENDS += " \
	python3-hgtools \
	python3-setuptools-scm-native \
	python3-toml-native \
"

RDEPENDS_${PN} = " \
	python3-logging \
	python3-importlib-metadata \
	python3-typing \
"
