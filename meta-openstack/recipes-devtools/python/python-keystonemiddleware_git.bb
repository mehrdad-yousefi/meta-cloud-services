DESCRIPTION = "Middleware for OpenStack Identity API"
HOMEPAGE = "https://launchpad.net/keystonemiddleware"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4a4d0e932ffae1c0131528d30d419c55"

PR = "r0"
SRCNAME = "keystonemiddleware"

SRC_URI = "\
	git://git.openstack.org/openstack/keystonemiddleware;branch=master \
	"

PV="1.0.0+git${SRCPV}"
SRCREV="ce965ead938015cb7410f21141f5d76df4b3a0ce"
S = "${WORKDIR}/git"

inherit setuptools

DEPENDS += " \
        python-pip \
        python-pbr \
        "

RDEPENDS_${PN} += " \
	python-pbr \
	"
