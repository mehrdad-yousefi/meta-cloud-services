DESCRIPTION = "API supporting parsing command line arguments and .ini style configuration files."
HOMEPAGE = "https://pypi.python.org/pypi/oslo.config/1.1.0"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c46f31914956e4579f9b488e71415ac8"

PR = "r0"
SRCNAME = "oslo.config"

SRC_URI = "https://pypi.python.org/packages/source/o/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "d51fd561300f46945dd24977c429280c"
SRC_URI[sha256sum] = "4709df3a8ba05e6a47300770f1c90ade77b3d095f28e8f75191df8745268bb20"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

DEPENDS += " \
        python-pbr \
        python-pip \
        "

RDEPENDS_${PN} += "python-pbr"
