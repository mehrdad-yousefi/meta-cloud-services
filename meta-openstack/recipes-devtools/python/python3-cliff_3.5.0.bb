DESCRIPTION = "Command Line Interface Formulation Framework"
HOMEPAGE = "https://github.com/dreamhost/cliff"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI[md5sum] = "45a7f6f6e9e392ad8dbf79f802930047"
SRC_URI[sha256sum] = "5bfb684b5fcdff0afaaccd1298a376c0e62e644c46b7e9abc034595b41fe1759"

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
