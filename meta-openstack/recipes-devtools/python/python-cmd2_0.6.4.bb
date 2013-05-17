DESCRIPTION = "Extra features for standard library's cmd module"
HOMEPAGE = "http://packages.python.org/cmd2/"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://setup.py;beginline=21;endline=21;md5=25c0f7ede01b1eab41daf880e5791f05"

PR = "r0"
SRCNAME = "cmd2"

SRC_URI = "http://pypi.python.org/packages/source/c/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "60a07255bbcb4342888b1574f46e56ea"
SRC_URI[sha256sum] = "ff52cb800d931bbd0ce4b05bac0b024cf34ec3a04f66eadcb7d3f7dda42429ba"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools 

RDEPENDS_${PN} += "python-pyparsing"
