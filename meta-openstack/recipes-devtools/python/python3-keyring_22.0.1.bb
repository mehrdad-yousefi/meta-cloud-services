DESCRIPTION = "Store and access your passwords safely"
HOMEPAGE = "https://pypi.python.org/pypi/keyring/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7a7126e068206290f3fe9f8d6c713ea6"

SRC_URI[md5sum] = "88e1607f9f40b82ab9e28529eec3edbc"
SRC_URI[sha256sum] = "9acb3e1452edbb7544822b12fd25459078769e560fa51f418b6d00afaa6178df"

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
