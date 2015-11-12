DESCRIPTION = "OpenStack Client Configuation Library"
HOMEPAGE = "https://pypi.python.org/pypi/os-client-config"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

PV = "1.9.0"
SRCREV = "790fac98542ba303274180831cbd9a03604a84e8"

SRCNAME = "os-client-config"
SRC_URI = "git://github.com/openstack/${SRCNAME}.git"

S = "${WORKDIR}/git"

inherit distutils

DEPENDS += " \
        python-pbr \
        "

RDEPENDS_${PN} += " \
        python-pbr \
        "
