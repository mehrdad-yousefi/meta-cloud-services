DESCRIPTION = "A comprehensive HTTP client library"
HOMEPAGE = "https://code.google.com/p/httplib2/"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=01abba5d32279f9ed6b3350390258547"

SRCNAME = "httplib2"

SRC_URI = "https://pypi.python.org/packages/ff/a9/5751cdf17a70ea89f6dde23ceb1705bfb638fd8cee00f845308bf8d26397/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "bd1b1445b3b2dfa7276b09b1a07b7f0e"
SRC_URI[sha256sum] = "c3aba1c9539711551f4d83e857b316b5134a1c4ddce98a875b7027be7dd6d988"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

do_install_append() {
	perm_files=`find "${D}${PYTHON_SITEPACKAGES_DIR}/" -name "top_level.txt"`
	for f in $perm_files; do
		chmod 644 "${f}"
	done
}
