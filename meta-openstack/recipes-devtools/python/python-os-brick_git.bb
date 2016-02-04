DESCRIPTION = "OpenStack Cinder brick library for managing local volume attaches"
HOMEPAGE = "https://github.com/openstack/os-brick"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

SRC_URI = "\
	git://github.com/openstack/os-brick.git;branch=master \
	"

PV = "0.5.0+git${SRCPV}"
SRCREV = "5ac54d4e0c89daba1be80702ee4060a538c08754"
S = "${WORKDIR}/git"

inherit setuptools

FILES_${PN} += "${datadir}/etc/*"

DEPENDS += " \
        python-pbr \
        "

RDEPENDS_${PN} += " \
        python-pbr \
	"
