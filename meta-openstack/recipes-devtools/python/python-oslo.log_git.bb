DESCRIPTION = "Oslo Log Library"
HOMEPAGE = "https://launchpad.net/oslo"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

PR = "r0"

SRCNAME = "oslo.log"
SRC_URI = "git://github.com/openstack/${SRCNAME}.git"

PV = "0.3.0"
SRCREV = "5139941a0c8d63ae33421a2082e35fae0f800b67"
S = "${WORKDIR}/git"

inherit setuptools

DEPENDS += " \
        python-pip \
        python-babel \
        python-pbr \
        "

# RDEPENDS_default: 
RDEPENDS_${PN} += " \
        bash \
        python-pbr \
        python-iso8601 \
        python-oslo.config \
        python-oslo.context \
        python-oslo.i18n \
        python-oslo.utils \
        python-oslo.serialization\
        "
