DESCRIPTION = "Command Line Interface Formulation Framework"
HOMEPAGE = "https://github.com/dreamhost/cliff"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI[md5sum] = "89e96c6c8c5922832e124ed81c21a55b"
SRC_URI[sha256sum] = "622e777b8ac2eb479708fe53893c37b2fd5469ce2c6c5b794a658246f05c6b81"

inherit pypi

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
