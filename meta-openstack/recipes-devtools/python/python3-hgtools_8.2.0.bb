DESCRIPTION = "Classes and setuptools plugin for Mercurial repositories"
HOMEPAGE = "https://pypi.python.org/pypi/hgtools"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7a7126e068206290f3fe9f8d6c713ea6"

SRC_URI[md5sum] = "200c967071c63efeb869470d24f250e3"
SRC_URI[sha256sum] = "5f30e3e7729f67e414b63ae91697743bb2ec72f3cac0c514d16fd3c21bd25300"

DEPENDS += " \
	python3-setuptools-scm-native \
	python3-toml-native \
"

inherit setuptools3 pypi

