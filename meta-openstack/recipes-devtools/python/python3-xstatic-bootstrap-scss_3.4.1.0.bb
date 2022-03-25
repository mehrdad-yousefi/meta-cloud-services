DESCRIPTION = "%DESCRIPTION%"
HOMEPAGE = "%URL%"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PYPI_PACKAGE = "XStatic-Bootstrap-SCSS"

SRC_URI[md5sum] = "01b41f33c6c57d1a5d59f41ce360bdd0"
SRC_URI[sha256sum] = "5cb56f0090cb6489d643730de57c68d8a6714f2b9fe526ac89bb68f5d77dfe10"

inherit setuptools3 pypi

# DEPENDS_default: python-pip

DEPENDS += " \
        ${PYTHON_PN}-pip \
        "

# RDEPENDS:default: 
RDEPENDS:${PN} += " \
        "
