DESCRIPTION = "Fixtures, reusable state for writing clean tests and more"
HOMEPAGE = "https://pypi.python.org/pypi/fixtures/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=239e2f4698b85aad5ed39bae5d2ef226"

PR = "r0"
SRCNAME = "fixtures"

SRC_URI = "https://pypi.python.org/packages/source/f/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "4f3225a80397796be85729b659241610"
SRC_URI[sha256sum] = "4494c4862ad99ffb8354f7456f1c9a4ba68b607d9dabb912999d4ad60c7d9f54"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

DISTUTILS_INSTALL_ARGS = "--root=${D} \
    --prefix=${prefix} \
    --install-lib=${PYTHON_SITEPACKAGES_DIR} \
    --install-data=${datadir}"

DEPENDS += " \
	python-pbr \
	"

RDEPENDS_${PN} += "python-testtools \
	python-pbr \
	"
