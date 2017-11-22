DESCRIPTION = "Python library to interact with Apache HBase"
HOMEPAGE = "https://pypi.python.org/pypi/happybase/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.rst;md5=41f55ae3d7000e4323e84c468d8b42ee"

SRC_URI[md5sum] = "62a09c784a65161e9f5f01129d115457"
SRC_URI[sha256sum] = "e20376e2e32291798d2226502994134c1c4e175136d8375b3c517a234fa22481"

inherit setuptools pypi

do_install_append() {
	perm_files=$(find "${D}${PYTHON_SITEPACKAGES_DIR}/" -name "top_level.txt")
	perm_files="$perm_files "$(find "${D}${PYTHON_SITEPACKAGES_DIR}/" -name "PKG-INFO")
	for f in $perm_files; do
		chmod 644 "${f}"
	done
}
