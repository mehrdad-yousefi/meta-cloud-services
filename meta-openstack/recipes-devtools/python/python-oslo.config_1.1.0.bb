DESCRIPTION = "API supporting parsing command line arguments and .ini style configuration files."
HOMEPAGE = "https://pypi.python.org/pypi/oslo.config/1.1.0"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c46f31914956e4579f9b488e71415ac8"

PR = "r0"
SRCNAME = "oslo.config"

SRC_URI = "https://pypi.python.org/packages/source/o/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "35fc1adbc70234291af09673fd481705"
SRC_URI[sha256sum] = "fe5dedb9b47c508eb886a7b9b96eb7667597af407ff42853db82b4b9e949ea82"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools


