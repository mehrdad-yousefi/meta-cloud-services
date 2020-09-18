DESCRIPTION = "Translation library for Python"
HOMEPAGE = "https://github.com/tuvistavie/python-i18n"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://README.md;md5=57cb947993e30ec5ab6df3f12d04ebad"

PYPI_PACKAGE = "python-i18n"

SRC_URI[md5sum] = "581de49007179e536c4c47982a651cea"
SRC_URI[sha256sum] = "df97f3d2364bf3a7ebfbd6cbefe8e45483468e52a9e30b909c6078f5f471e4e8"

inherit setuptools3 pypi

# DEPENDS_default: python-pip

DEPENDS += " \
        ${PYTHON_PN}-pip \
        "

# RDEPENDS_default: 
RDEPENDS_${PN} += " \
        ${PYTHON_PN}-pyyaml \
        "
