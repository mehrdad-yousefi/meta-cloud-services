DESCRIPTION = "Oslo Serialization API"
HOMEPAGE = "https://launchpad.net/oslo"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

PR = "r0"

SRCNAME = "oslo.serialization"
SRC_URI = "git://github.com/openstack/${SRCNAME}.git"

PV = "1.0.0"
SRCREV = "ddde5a5a5ac4ff2ebaed7297bf35536b51aeabda"
S = "${WORKDIR}/git"

inherit setuptools

# DEPENDS_default: python-pip

DEPENDS += " \
        python-pip \
        "

# RDEPENDS_default: 
RDEPENDS_${PN} += " \
        "
