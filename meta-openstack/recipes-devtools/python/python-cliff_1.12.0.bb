DESCRIPTION = "Command Line Interface Formulation Framework"
HOMEPAGE = "https://github.com/dreamhost/cliff"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRCNAME = "cliff"

SRC_URI = "https://pypi.python.org/packages/source/c/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "feaa48620db2aeb9306ff33e5494fccc"
SRC_URI[sha256sum] = "7609abc1789522fc4e228ea5567a9fd1db3963850396178adca3332cdd9c929a"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

RDEPENDS_${PN} += "python-prettytable \
            python-cmd2 \
            python-pyparsing"

CLEANBROKEN = "1"
