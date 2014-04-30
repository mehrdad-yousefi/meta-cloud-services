DESCRIPTION = "Client library for Barbican API"
HOMEPAGE = "https://github.com/stackforge/python-barbicanclient"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e031cff4528978748f9cc064c6e6fa73"

PR = "r0"

SRC_URI = "\
	git://github.com/stackforge/python-barbicanclient.git;branch=master \
	"

PV="2.1.0+git${SRCPV}"
SRCREV="80cd5724397d0c9c3371f7290591f9b06f610f88"
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
