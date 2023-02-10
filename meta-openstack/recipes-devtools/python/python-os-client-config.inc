DESCRIPTION = "OpenStack Client Configuation Library"
HOMEPAGE = "https://pypi.python.org/pypi/os-client-config"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

PV = "2.1.0"
SRCREV = "bc96c23a9c44cee8f54d7349b288a406cec3f10a"

SRCNAME = "os-client-config"
SRC_URI = "git://github.com/openstack/${SRCNAME}.git;branch=master;protocol=https"

S = "${WORKDIR}/git"

DEPENDS += " \
        ${PYTHON_PN}-pbr \
        "
# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        ${PYTHON_PN}-pbr-native \
        "

RDEPENDS:${PN} += " \
        ${PYTHON_PN}-pbr \
        ${PYTHON_PN}-pyyaml \
        ${PYTHON_PN}-appdirs \
        ${PYTHON_PN}-keystoneauth1 \
        ${PYTHON_PN}-requestsexceptions \
        "
