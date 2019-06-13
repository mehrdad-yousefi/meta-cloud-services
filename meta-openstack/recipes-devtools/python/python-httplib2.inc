DESCRIPTION = "A comprehensive HTTP client library"
HOMEPAGE = "https://code.google.com/p/httplib2/"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=341f12f35eee133c8ce15c04a042fb72"

SRC_URI[md5sum] = "c0c3b1c1a1c51fa40f46271d95f74fdc"
SRC_URI[sha256sum] = "d1146939d270f1f1eb8cbf8f5aa72ff37d897faccca448582bb1e180aeb4c6b2"

inherit pypi

do_install_append() {
	perm_files=`find "${D}${PYTHON_SITEPACKAGES_DIR}/" -name "top_level.txt"`
	for f in $perm_files; do
		chmod 644 "${f}"
	done
}
