DESCRIPTION = "oslo.i18n library"
HOMEPAGE = "http://launchpad.net/oslo"
SECTION = "devel/python"
LICENSE = "Apache-2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

PR = "r0"

SRCNAME = "oslo.i18n"
SRC_URI = "http://pypi.python.org/packages/source/o/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "7a4e9139c8d0a28bb07ff4c4ec1218cb"
SRC_URI[sha256sum] = "c682a261de6b0d75291478c422e9ff75c220fa5e58856735d988c09bf14773bb"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

# DEPENDS_default: python-pip

DEPENDS += " \
        python-pip \
        "

# RDEPENDS_default: 
RDEPENDS_${PN} += " \
        python-babel \
        "
