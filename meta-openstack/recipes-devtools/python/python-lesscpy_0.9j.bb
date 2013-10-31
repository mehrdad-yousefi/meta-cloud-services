DESCRIPTION = "Python lesscpy: Python LESS Compiler"
HOMEPAGE = "https://pypi.python.org/pypi/lesscpy"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a01aae31681ac25b4c46f98d627b9b5d"

PR = "r0"
SRCNAME = "lesscpy"

SRC_URI = "https://pypi.python.org/packages/source/l/${SRCNAME}/${SRCNAME}-${PV}.tar.gz \
           file://0001-lesscpy-remove-explicit-python3.patch \
           file://0002-Description-Fixup-for-python3.3-compat.patch \
           "

DEPENDS += "python-ply"
RDEPENDS_${PN} += "python-ply"

SRC_URI[md5sum] = "a9587da0148463d6521f386294c9d6f3"
SRC_URI[sha256sum] = "fa01d435a1ab3abafba683519bdc7aca5e19399e96225e1a8bc1d660b566364d"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

DISTUTILS_INSTALL_ARGS = "--root=${D} \
    --prefix=${prefix} \
    --install-lib=${PYTHON_SITEPACKAGES_DIR} \
    --install-data=${datadir}"
