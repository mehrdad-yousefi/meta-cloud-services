DESCRIPTION = "Client library for Barbican API"
HOMEPAGE = "https://github.com/stackforge/python-barbicanclient"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e031cff4528978748f9cc064c6e6fa73"

SRC_URI = "\
	git://github.com/openstack/python-barbicanclient.git;branch=stable/pike \
	"

PV = "4.5.2+git${SRCPV}"
SRCREV = "775de93a612db866bb39ba6828f3e7bd1aa3c9f5"
S = "${WORKDIR}/git"

inherit setuptools

DEPENDS += " \
        python-pip \
        python-pbr \
        "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python-pbr-native \
        "

RDEPENDS_${PN} += " \
        python-pbr \
        python-requests \
        python-six \
        python-cliff \
        python-keystoneauth1 \
        python-oslo.i18n \
        python-oslo.serialization \
        python-oslo.utils \
        "
