DESCRIPTION = "Client library for Barbican API"
HOMEPAGE = "https://github.com/stackforge/python-barbicanclient"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e031cff4528978748f9cc064c6e6fa73"

PR = "r0"

SRC_URI = "\
	git://github.com/openstack/python-barbicanclient.git;branch=master \
	"

PV="2.2.1+git${SRCPV}"
SRCREV="ac30643631b6bc1c40116061f8eb280a7881e422"
S = "${WORKDIR}/git"

inherit setuptools

DEPENDS += " \
        python-pip \
        python-pbr \
        "

RDEPENDS_${PN} += " \
        python-requests \
        python-six \
        python-keystoneclient \
	"
