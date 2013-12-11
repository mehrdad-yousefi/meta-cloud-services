DESCRIPTION = "The modular source code checker: pep8, pyflakes and co"
HOMEPAGE = "https://github.com/dreamhost/cliff"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7a76e57e683629e1ac2a49406169c2a3"

PR = "r0"
SRCNAME = "flake8"

SRC_URI = "https://pypi.python.org/packages/source/f/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "cf326cfb88a1db6c5b29a3a6d9efb257"
SRC_URI[sha256sum] = "098ab7991067c08cfaa4716de20066d90f66dbc71502114ea8cad9a9fd5c9512"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

RDEPENDS_${PN} += "python-prettytable \
            python-cmd2 \
            python-pyparsing \
            python-mccabe \
            python-pep8 \
            python-pyflakes"
