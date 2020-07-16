DESCRIPTION = "Command Line Interface Formulation Framework"
HOMEPAGE = "https://github.com/dreamhost/cliff"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI[md5sum] = "0e935a090e19358973fdbcc4dfbcdaab"
SRC_URI[sha256sum] = "611595ad7b4bdf57aa252027796dac3273ab0f4bc1511e839cce230a351cb710"

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
