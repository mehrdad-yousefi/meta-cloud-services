DESCRIPTION = "Manage dynamic plugins for Python applications"
HOMEPAGE = "https://github.com/dreamhost/stevedore"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

PR = "r0"

SRCNAME = "stevedore"
SRC_URI = "http://pypi.python.org/packages/source/s/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "bd82728ab03e62121fbbb077bcd55fdb"
SRC_URI[sha256sum] = "3f70db9052c26e66dac61cb73d8c6f5211373983d39872addab617c759db4b45"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

DEPENDS += " \
        python-pip \
        python-pbr \
        "

RDEPENDS_${PN} += " \
        python-pbr \
        "
