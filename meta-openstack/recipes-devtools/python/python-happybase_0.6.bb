DESCRIPTION = "Python library to interact with Apache HBase"
HOMEPAGE = "https://pypi.python.org/pypi/happybase/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.rst;md5=41f55ae3d7000e4323e84c468d8b42ee"

PR = "r0"
SRCNAME = "happybase"

SRC_URI = "https://pypi.python.org/packages/source/h/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "28905e2a334d6d7b42495f2c5ca46add"
SRC_URI[sha256sum] = "74312a83c7f67d8a362649a822259fcf5983ea9b9e5f2e4e17d67109435cc00e"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

do_install_append() {
	perm_files=`find "${D}${PYTHON_SITEPACKAGES_DIR}/" -name "top_level.txt"`
	for f in $perm_files; do
		chmod 644 "${f}"
	done
}