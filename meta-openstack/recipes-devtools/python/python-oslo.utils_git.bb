DESCRIPTION = "Oslo utils"
HOMEPAGE = "https://launchpad.net/oslo"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

PR = "r0"

SRCNAME = "oslo.utils"
SRC_URI = "git://github.com/openstack/${SRCNAME}.git"

PV = "1.3.0"
SRCREV = "ed4e2d775a56b9d47ed314f96dccd9221a91e241"
S = "${WORKDIR}/git"

inherit setuptools

# DEPENDS_default: python-pip

DEPENDS += " \
        python-pip \
        python-pbr \
        "

# RDEPENDS_default: 
RDEPENDS_${PN} += " \
        python-pbr \
        "
