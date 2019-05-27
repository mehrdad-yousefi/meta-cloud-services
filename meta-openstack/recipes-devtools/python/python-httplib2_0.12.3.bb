DESCRIPTION = "A comprehensive HTTP client library"
HOMEPAGE = "https://code.google.com/p/httplib2/"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=ad87b270277b5f40e2a281d9f7dde584"

SRC_URI[md5sum] = "f78ce222216865271f2672e6941174d5"
SRC_URI[sha256sum] = "a18121c7c72a56689efbf1aef990139ad940fee1e64c6f2458831736cd593600"

inherit setuptools pypi

do_install_append() {
	perm_files=`find "${D}${PYTHON_SITEPACKAGES_DIR}/" -name "top_level.txt"`
	for f in $perm_files; do
		chmod 644 "${f}"
	done
}
