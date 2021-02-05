DESCRIPTION = "Command Line Interface Formulation Framework"
HOMEPAGE = "https://github.com/dreamhost/cliff"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI[md5sum] = "8dbf43ad5486186eb80e985ddb38fdec"
SRC_URI[sha256sum] = "a3f4fa67eeafbcfa7cf9fe4b1755d410876528e1d0d115740db00b50a1250272"

inherit setuptools3 pypi

DEPENDS += "\
    ${PYTHON_PN}-pbr \
    "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
    ${PYTHON_PN}-pbr-native \
    "

RDEPENDS_${PN} += " \
            ${PYTHON_PN}-cmd2 \
            ${PYTHON_PN}-pbr \
            ${PYTHON_PN}-pyparsing \
            ${PYTHON_PN}-prettytable \
            ${PYTHON_PN}-six \
            ${PYTHON_PN}-stevedore \
            ${PYTHON_PN}-pyyaml \
"

CLEANBROKEN = "1"
