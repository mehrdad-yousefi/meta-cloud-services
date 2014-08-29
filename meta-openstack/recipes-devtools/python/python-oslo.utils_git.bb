DESCRIPTION = "Oslo utils"
HOMEPAGE = "https://launchpad.net/oslo"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

PR = "r0"

SRCNAME = "oslo.utils"
SRC_URI = "git://github.com/openstack/${SRCNAME}.git"

PV = "0.2.0"
SRCREV = "118f7ea84a476604f2498fc4d28c9c2b266c717a"
S = "${WORKDIR}/git"

inherit setuptools

# DEPENDS_default: python-pip

DEPENDS += " \
        python-pip \
        "

# RDEPENDS_default: 
RDEPENDS_${PN} += " \
        "
