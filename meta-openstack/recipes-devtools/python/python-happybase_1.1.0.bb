DESCRIPTION = "Python library to interact with Apache HBase"
HOMEPAGE = "https://pypi.python.org/pypi/happybase/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.rst;md5=41f55ae3d7000e4323e84c468d8b42ee"

PR = "r0"
SRCNAME = "happybase"

SRC_URI = "https://pypi.python.org/packages/8d/a4/9c1202ad4276d4e845594d534397c07082b90aee68c67f378fac38629e6f/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "62a09c784a65161e9f5f01129d115457"
SRC_URI[sha256sum] = "e20376e2e32291798d2226502994134c1c4e175136d8375b3c517a234fa22481"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

do_install_append() {
	perm_files=`find "${D}${PYTHON_SITEPACKAGES_DIR}/" -name "top_level.txt"`
	for f in $perm_files; do
		chmod 644 "${f}"
	done
}
