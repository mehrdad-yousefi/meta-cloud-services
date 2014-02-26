DESCRIPTION = "A comprehensive HTTP client library"
HOMEPAGE = "https://code.google.com/p/httplib2/"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://README;beginline=100;endline=121;md5=2815fff50ab2ea49633a03e75bb1f2da"

PR = "r0"
SRCNAME = "httplib2"

SRC_URI = "https://httplib2.googlecode.com/files/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "a143657998f6752be998e2ec740e7dec"
SRC_URI[sha256sum] = "af689bc3cb10a95721eb0d0cf806202a699e7799dacd3497f63b48b2ba429c3f"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

do_install_append() {
	perm_files=`find "${D}${PYTHON_SITEPACKAGES_DIR}/" -name "top_level.txt"`
	for f in $perm_files; do
		chmod 644 "${f}"
	done
}