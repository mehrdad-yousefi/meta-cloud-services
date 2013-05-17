DESCRIPTION = "Command Line Interface Formulation Framework"
HOMEPAGE = "https://github.com/dreamhost/cliff"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

PR = "r0"
SRCNAME = "cliff"

SRC_URI = "https://pypi.python.org/packages/source/c/${SRCNAME}/${SRCNAME}-${PV}.tar.gz \
           file://remove-distribute-dependency.patch"

SRC_URI[md5sum] = "a42f7894dbc70f42c0979042175f1b8f"
SRC_URI[sha256sum] = "7c0250b5139993d04dcbb8b9d05376094b7271586b3698b4764c7c6f4697e0f8"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

RDEPENDS_${PN} += "python-prettytable \
            python-cmd2 \
            python-pyparsing"
