DESCRIPTION = "Highly concurrent networking library"
HOMEPAGE = "http://pypi.python.org/pypi/eventlet"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=56472ad6de4caf50e05332a34b66e778"

SRCNAME = "eventlet"

SRC_URI = "https://pypi.python.org/packages/cb/ec/eae487c106a7e38f86ac4cadafb3eec77d29996f64ca0c7015067538069b/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "92aaac4c0abaddff9329f55d8f5bcd76"
SRC_URI[sha256sum] = "08faffab88c1b08bd53ea28bf084a572c89f7e7648bd9d71e6116ac17a51a15d"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
