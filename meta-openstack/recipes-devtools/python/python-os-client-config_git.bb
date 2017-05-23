DESCRIPTION = "OpenStack Client Configuation Library"
HOMEPAGE = "https://pypi.python.org/pypi/os-client-config"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

PV = "1.21.1"
SRCREV = "c4742ec391151e918046efa5a550e012fe9d5081"

SRCNAME = "os-client-config"
SRC_URI = "git://github.com/openstack/${SRCNAME}.git;branch=stable/newton"

S = "${WORKDIR}/git"

inherit setuptools

DEPENDS += " \
        python-pbr \
        "

RDEPENDS_${PN} += " \
        python-pbr \
        python-pyyaml \
        python-appdirs \
        python-keystoneauth1 \
        python-requestsexceptions \
        "
