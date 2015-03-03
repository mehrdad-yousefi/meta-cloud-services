DESCRIPTION = "The modular source code checker: pep8, pyflakes and co"
HOMEPAGE = "https://github.com/dreamhost/cliff"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7a76e57e683629e1ac2a49406169c2a3"

PR = "r0"
SRCNAME = "flake8"

SRC_URI = "https://pypi.python.org/packages/source/f/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "488d6166f6b9ef9fe9d433b95e77dc07"
SRC_URI[sha256sum] = "5ee1a43ccd0716d6061521eec6937c983efa027793013e572712c4da55c7c83e"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

RDEPENDS_${PN} += "python-prettytable \
            python-cmd2 \
            python-pyparsing \
            python-mccabe \
            python-pep8 \
            python-pyflakes"
