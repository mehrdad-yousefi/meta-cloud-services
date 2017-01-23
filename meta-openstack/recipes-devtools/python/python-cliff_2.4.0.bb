DESCRIPTION = "Command Line Interface Formulation Framework"
HOMEPAGE = "https://github.com/dreamhost/cliff"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRCNAME = "cliff"

SRC_URI = "https://pypi.python.org/packages/5a/86/61cb36713a6feb28cfb3201022a218c359dc988cf9f65b2e2681cb33cf8d/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "26ef765d200e54aebf72984dfce5f255"
SRC_URI[sha256sum] = "cc9175e3c2a42bc06343290a1218bc6b70f36883520b2948f743c5f9ae917675"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools rmargparse

DEPENDS += "\
    python-pbr \
    "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
    python-pbr-native \
    "

RDEPENDS_${PN} += "python-prettytable \
            python-cmd2 \
            python-pbr \
            python-pyparsing \
            python-prettytable \
            python-pyparsing \
            python-six \
            python-stevedore \
            python-unicodecsv \
            python-pyyaml \
"

CLEANBROKEN = "1"
