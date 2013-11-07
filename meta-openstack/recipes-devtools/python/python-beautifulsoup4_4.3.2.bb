DESCRIPTION = "Screen-scraping library"
HOMEPAGE = "https://pypi.python.org/pypi/beautifulsoup4/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING.txt;md5=83e365dc17176bd72ba7d08ca0555efa"

PR = "r0"
SRCNAME = "beautifulsoup4"

SRC_URI = "https://pypi.python.org/packages/source/b/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "b8d157a204d56512a4cc196e53e7d8ee"
SRC_URI[sha256sum] = "a2b29bd048ca2fe54a046b29770964738872a9747003a371344a93eedf7ad58e"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

# avoid "error: option --single-version-externally-managed not recognized"
DISTUTILS_INSTALL_ARGS = "--root=${D} \
    --prefix=${prefix} \
    --install-lib=${PYTHON_SITEPACKAGES_DIR} \
    --install-data=${datadir}"
