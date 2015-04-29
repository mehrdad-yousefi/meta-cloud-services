DESCRIPTION = "Tools for using a Web Server Gateway Interface stack"
HOMEPAGE = "http://pythonpaste.org/"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://docs/license.txt;md5=1798f29d55080c60365e6283cb49779c"

SRCNAME = "Paste"

SRC_URI = "https://pypi.python.org/packages/source/P/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "5aa1890d20e6f93b46e855aa1e17ba27"
SRC_URI[sha256sum] = "28383e843cb46a9375a90da6e2ec5fcd7704ed9f3f3b5e954928beb52b0e5b41"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
