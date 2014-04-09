DESCRIPTION = "Client library for OpenStack Object Storage API"
HOMEPAGE = "https://github.com/openstack/python-swiftclient"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

PR = "r0"
SRCNAME = "swiftclient"

SRC_URI = "git://github.com/openstack/python-swiftclient.git;branch=master"

PV="2.0.2+git${SRCPV}"
SRCREV="fa65fbbce51a7a603a6453da51db41061e4388f9"
S = "${WORKDIR}/git"

inherit setuptools python-dir

do_install_append() {
    cp -r tests ${D}/${PYTHON_SITEPACKAGES_DIR}/${SRCNAME}/
}

DEPENDS += " \
        python-pip \
        python-pbr \
        "

RDEPENDS_${PN} += " \
        python-simplejson \
        python-pbr \
        "
