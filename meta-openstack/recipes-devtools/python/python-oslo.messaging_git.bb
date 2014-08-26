DESCRIPTION = "Oslo Messaging API"
HOMEPAGE = "https://launchpad.net/oslo"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c46f31914956e4579f9b488e71415ac8"

PR = "r0"

SRCNAME = "oslo.messaging"
SRC_URI = "git://github.com/openstack/${SRCNAME}.git"

PV = "1.4.0.0a4"
SRCREV = "5be1b6a6a93e2be1fd6adef109a016f49ed98b0a"
S = "${WORKDIR}/git"

inherit setuptools

# DEPENDS_default: python-pip

DEPENDS += " \
        python-pip \
        "

# RDEPENDS_default: 
RDEPENDS_${PN} += " \
        "
