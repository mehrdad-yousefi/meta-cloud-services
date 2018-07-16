DESCRIPTION = "A comprehensive HTTP client library"
HOMEPAGE = "https://code.google.com/p/httplib2/"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=4d159ceca4925adea3407818d4a87968"

SRC_URI[md5sum] = "9aa3e074da9a235cd675dd65e1fbcf39"
SRC_URI[sha256sum] = "e71daed9a0e6373642db61166fa70beecc9bf04383477f84671348c02a04cbdf"

inherit setuptools pypi

do_install_append() {
	perm_files=`find "${D}${PYTHON_SITEPACKAGES_DIR}/" -name "top_level.txt"`
	for f in $perm_files; do
		chmod 644 "${f}"
	done
}
