DESCRIPTION = "Python lesscpy: Python LESS Compiler"
HOMEPAGE = "https://pypi.python.org/pypi/lesscpy"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a01aae31681ac25b4c46f98d627b9b5d"

DEPENDS += "${PYTHON_PN}-ply"
RDEPENDS_${PN} += "${PYTHON_PN}-ply"

SRC_URI[md5sum] = "efe82be479ddb7bdc48b2114dab94b20"
SRC_URI[sha256sum] = "7b664f60818a16afa8cc9f1dd6d9b17f944e0ce94e50787d76f81bc7a8648cce"

inherit setuptools3 pypi

DISTUTILS_INSTALL_ARGS = "--root=${D} \
    --prefix=${prefix} \
    --install-lib=${PYTHON_SITEPACKAGES_DIR} \
    --install-data=${datadir}"
