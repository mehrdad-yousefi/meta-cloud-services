DESCRIPTION = "API supporting parsing command line arguments and .ini style configuration files."
HOMEPAGE = "https://pypi.python.org/pypi/oslo.config/1.1.0"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c46f31914956e4579f9b488e71415ac8"

SRCNAME = "oslo.config"

SRC_URI = "https://pypi.python.org/packages/source/o/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "f2e8c995a9452ef6a02c7270561cadcb"
SRC_URI[sha256sum] = "a5f61075b16e9155cc4e5aceab98f6e47d85bccaeb3739e364e151a9af0bc1ed"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

DEPENDS += " \
        python-pbr \
        python-pip \
        "

RDEPENDS_${PN} += "python-pbr"
