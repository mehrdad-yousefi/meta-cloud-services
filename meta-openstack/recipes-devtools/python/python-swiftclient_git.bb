DESCRIPTION = "Client library for OpenStack Object Storage API"
HOMEPAGE = "https://github.com/openstack/python-swiftclient"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

PR = "r0"
SRCNAME = "swiftclient"

SRC_URI = "git://github.com/openstack/python-swiftclient.git;branch=master"

PV="2.3.1+git${SRCPV}"
SRCREV="8aff0bda9c35ab96146f4f419803e62710ab5618"
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
