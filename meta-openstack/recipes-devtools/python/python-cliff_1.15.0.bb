DESCRIPTION = "Command Line Interface Formulation Framework"
HOMEPAGE = "https://github.com/dreamhost/cliff"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRCNAME = "cliff"

SRC_URI = "https://pypi.python.org/packages/source/c/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "23f9187d6d7ffa70d8f725381bb1094f"
SRC_URI[sha256sum] = "f5ba6fe0940547549947d5a24ca3354145a603d3a9ba054f209d20b66dc02be7"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools rmargparse

DEPENDS += "\
    python-pbr \
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
