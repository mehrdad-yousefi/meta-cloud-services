DESCRIPTION = "API supporting parsing command line arguments and .ini style configuration files."
HOMEPAGE = "https://pypi.python.org/pypi/oslo.config/1.1.0"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c46f31914956e4579f9b488e71415ac8"

SRCNAME = "oslo.config"

SRC_URI = "https://pypi.python.org/packages/source/o/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "1ef0fb7c6ec5c8bdb0e0340a2e404967"
SRC_URI[sha256sum] = "0f9b5a12dae4f26aa8a82e71523a20ce183269b56722ccf3fd2149b1bba7d46a"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

DEPENDS += " \
        python-pbr \
        python-pip \
        "

RDEPENDS_${PN} += "python-pbr"
