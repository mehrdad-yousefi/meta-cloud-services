DESCRIPTION = "Extensions to the Python standard library unit testing framework"
HOMEPAGE = "https://pypi.python.org/pypi/testtools/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=30a345a6863019b548dba40895dfee79"

PR = "r0"
SRCNAME = "testtools"

SRC_URI = "https://pypi.python.org/packages/source/t/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "310ce6fab8affecdc7415ff910a83c42"
SRC_URI[sha256sum] = "5b62231fea71ccb2361d48286481b198ccb8768bf81f8aaec1c8d5fb98eaaca3"


S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
