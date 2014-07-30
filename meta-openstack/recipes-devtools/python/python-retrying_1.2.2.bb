DESCRIPTION = "Retrying"
HOMEPAGE = "https://github.com/rholder/retrying"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=175792518e4ac015ab6696d16c4f607e"

PR = "r0"

SRCNAME = "retrying"
SRC_URI = "http://pypi.python.org/packages/source/r/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "534825ad47c3e317f52090f642113870"
SRC_URI[sha256sum] = "fbeda85e94d103cf8bb36d29644abdc1e9ad367dd2c7160324fa60ee9d5193d0"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

# DEPENDS_default: python-pip

DEPENDS += " \
        python-pip \
        "

# RDEPENDS_default: 
RDEPENDS_${PN} += " \
        "
