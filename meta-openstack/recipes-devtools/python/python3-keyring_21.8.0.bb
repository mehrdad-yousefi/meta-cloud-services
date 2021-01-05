DESCRIPTION = "Store and access your passwords safely"
HOMEPAGE = "https://pypi.python.org/pypi/keyring/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7a7126e068206290f3fe9f8d6c713ea6"

SRC_URI[md5sum] = "08913a578efc485bd5763822234d27c6"
SRC_URI[sha256sum] = "1746d3ac913d449a090caf11e9e4af00e26c3f7f7e81027872192b2398b98675"

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
