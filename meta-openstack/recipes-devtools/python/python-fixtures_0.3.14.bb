DESCRIPTION = "Fixtures, reusable state for writing clean tests and more"
HOMEPAGE = "https://pypi.python.org/pypi/fixtures/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=239e2f4698b85aad5ed39bae5d2ef226"

PR = "r0"
SRCNAME = "fixtures"

SRC_URI = "https://pypi.python.org/packages/source/f/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "c63c79c87405dbdc8e0f877c3ff583fd"
SRC_URI[sha256sum] = "4cc3313e52519d2671bd22aacd4b3fde9d96b31eb49db04a7cd5ccc61fec5139"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

DISTUTILS_INSTALL_ARGS = "--root=${D} \
    --prefix=${prefix} \
    --install-lib=${PYTHON_SITEPACKAGES_DIR} \
    --install-data=${datadir}"