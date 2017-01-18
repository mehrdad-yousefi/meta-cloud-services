DESCRIPTION = "Python library to interact with Apache HBase"
HOMEPAGE = "https://pypi.python.org/pypi/happybase/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.rst;md5=41f55ae3d7000e4323e84c468d8b42ee"

PR = "r0"
SRCNAME = "happybase"

SRC_URI = "https://pypi.python.org/packages/e8/6e/21ec2ff3f14084b2247e59dba89aecf115d1093a5256a343a7b158984b7f/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "1274e74df553bbf800989578b7dfbe59"
SRC_URI[sha256sum] = "cee5f62735c6ba95c8f842decfd23bab5a07bc16cd0c5374f7461c975d4c608c"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

do_install_append() {
	perm_files=`find "${D}${PYTHON_SITEPACKAGES_DIR}/" -name "top_level.txt"`
	for f in $perm_files; do
		chmod 644 "${f}"
	done
}
