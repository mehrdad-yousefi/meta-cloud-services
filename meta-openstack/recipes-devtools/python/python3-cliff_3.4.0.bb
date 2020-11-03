DESCRIPTION = "Command Line Interface Formulation Framework"
HOMEPAGE = "https://github.com/dreamhost/cliff"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI[md5sum] = "62c1f79bd1675febb4d0a36341fab78d"
SRC_URI[sha256sum] = "49be854582ec4a74240cb72f287846f823cd8cbd2e25f924541d12f27104bda3"

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
