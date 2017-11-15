DESCRIPTION = "Set of handlers for the Python standard library's logging package"
HOMEPAGE = "https://pypi.python.org/pypi/logutils"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=44c35f0b8e2a27a2f33a4e4a5c65d014"

PR = "r0"
SRCNAME = "logutils"

SRC_URI = "https://pypi.python.org/packages/49/b2/b57450889bf73da26027f8b995fd5fbfab258ec24ef967e4c1892f7cb121/logutils-0.3.5.tar.gz"

SRC_URI[md5sum] = "fcd2f8e9217bfa0b580f253b35a9d954"
SRC_URI[sha256sum] = "bc058a25d5c209461f134e1f03cab637d66a7a5ccc12e593db56fbb279899a82"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

# avoid "error: option --single-version-externally-managed not recognized"
DISTUTILS_INSTALL_ARGS = "--root=${D} \
    --prefix=${prefix} \
    --install-lib=${PYTHON_SITEPACKAGES_DIR} \
    --install-data=${datadir}"
