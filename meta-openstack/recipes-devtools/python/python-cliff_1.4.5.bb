DESCRIPTION = "Command Line Interface Formulation Framework"
HOMEPAGE = "https://github.com/dreamhost/cliff"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

PR = "r0"
SRCNAME = "cliff"

SRC_URI = "https://pypi.python.org/packages/source/c/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "21743e9e800cf526e88e420f366a4c5c"
SRC_URI[sha256sum] = "0ec2c40e899cbb4d478aa946e1430600bf596ca2a3f12162a9514e9d580935ec"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

RDEPENDS_${PN} += "python-prettytable \
            python-cmd2 \
            python-pyparsing"
