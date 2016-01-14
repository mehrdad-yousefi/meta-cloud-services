DESCRIPTION = "A Python module for decorators, wrappers and monkey patching."
HOMEPAGE = "https://github.com/GrahamDumpleton/wrapt"
SECTION = "devel/python"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=848d45ec255e411c0ff82b034a49d8a0"

PV = "1.10.5"
SRCREV = "42af0563bf88e84d215dea9ea6f989cb867e930e"

SRCNAME = "wrapt"
SRC_URI = "git://github.com/GrahamDumpleton/${SRCNAME}.git"

S = "${WORKDIR}/git"

inherit setuptools
