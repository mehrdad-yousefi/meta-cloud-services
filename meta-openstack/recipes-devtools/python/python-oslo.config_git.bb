DESCRIPTION = "API supporting parsing command line arguments and .ini style configuration files."
HOMEPAGE = "https://pypi.python.org/pypi/oslo.config/2.6.0"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c46f31914956e4579f9b488e71415ac8"

PV = "2.6.0+git${SRCPV}"
SRCREV = "ee2bab65e9a2f38bb915f106a4da1520e4b5060c"

SRCNAME = "oslo.config"
SRC_URI = "git://github.com/openstack/${SRCNAME}.git"

S = "${WORKDIR}/git"

inherit setuptools rmargparse

DEPENDS += " \
        python-pbr \
        python-pip \
        "

RDEPENDS_${PN} += " \
    python-pbr \
    python-netaddr \
    python-six \
    python-stevedore \
    "
