DESCRIPTION = "Plugin for setuptools that enables git integration"
HOMEPAGE = "https://github.com/wichert/setuptools-git"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=3775480a712fc46a69647678acb234cb"

PR = "r0"
SRCNAME = "setuptools-git"

SRC_URI = "https://pypi.python.org/packages/source/s/${SRCNAME}/${SRCNAME}-${PV}b1.tar.gz"

SRC_URI[md5sum] = "ac67cbaa1336b7de25b1b5ff93b4e90d"
SRC_URI[sha256sum] = "dccd496b4166315c2b6b842f3dcd417b22e2cb43aaa4a8983b1ea0ceae0fe328"

S = "${WORKDIR}/${SRCNAME}-${PV}b1"

inherit setuptools

# conflicting file prevention
do_install_append() {
	rm -f ${D}${libdir}/python*/site-packages/site.py*
}
