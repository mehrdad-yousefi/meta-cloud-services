DESCRIPTION = "A comprehensive HTTP client library"
HOMEPAGE = "https://code.google.com/p/httplib2/"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=e199474a42f8d1baba57f39b790a557e"

SRC_URI[md5sum] = "ff90c595c6a58a954a65088b6a470999"
SRC_URI[sha256sum] = "6901c8c0ffcf721f9ce270ad86da37bc2b4d32b8802d4a9cec38274898a64044"

inherit pypi

do_install_append() {
	perm_files=`find "${D}${PYTHON_SITEPACKAGES_DIR}/" -name "top_level.txt"`
	for f in $perm_files; do
		chmod 644 "${f}"
	done
}
