DESCRIPTION = "Store and access your passwords safely"
HOMEPAGE = "https://pypi.python.org/pypi/keyring/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://CONTRIBUTORS.txt;md5=d21995fd789e7098b837c7af940c4d29"

PR = "r0"
SRCNAME = "keyring"

SRC_URI = "https://pypi.python.org/packages/source/k/${SRCNAME}/${SRCNAME}-${PV}.zip"

SRC_URI[md5sum] = "05307327b902116656e04a89ddda790d"
SRC_URI[sha256sum] = "0eb739976a31d607e8af52ce735a09e6b9b18516d809951bf268657fe1658cba"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
