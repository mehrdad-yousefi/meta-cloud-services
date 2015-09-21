DESCRIPTION = "Oslo Context Library"
HOMEPAGE = "https://launchpad.net/oslo"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

PR = "r0"

SRCNAME = "oslo.context"
SRC_URI = "git://github.com/openstack/${SRCNAME}.git"

PV = "0.1.0"
SRCREV = "205479f254e2bc90c0c142f1f75df500ae94f916"
S = "${WORKDIR}/git"

inherit setuptools

DEPENDS += " \
        python-pip \
        python-babel \
        python-pbr \
        "

# RDEPENDS_default: 
RDEPENDS_${PN} += " \
        python-pbr \
        bash \
        "
