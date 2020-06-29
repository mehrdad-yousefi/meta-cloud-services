DESCRIPTION = "The modular source code checker: pep8, pyflakes and co"
HOMEPAGE = "https://github.com/dreamhost/cliff"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=75b26781f1adf1aa310bda6098937878"

SRC_URI[md5sum] = "b11380b47468c3dc7323396d4b8c1746"
SRC_URI[sha256sum] = "f04b9fcbac03b0a3e58c0ab3a0ecc462e023a9faf046d57794184028123aa208"

inherit setuptools3 pypi

RDEPENDS_${PN} += "python3-prettytable \
            python3-cmd2 \
            python3-pyparsing \
            python3-mccabe \
            python3-pep8 \
            python3-pyflakes"
