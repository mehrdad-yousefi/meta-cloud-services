DESCRIPTION = "OpenStackClient Library"
HOMEPAGE = "http://opensource.perlig.de/rcssmin/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

SRCNAME = "osc-lib"

SRC_URI = "https://pypi.io/packages/source/o/${SRCNAME}/${SRCNAME}-${PV}.tar.gz \
"

SRC_URI[md5sum] = "08bf2b46089da52240893d99a3892897"
SRC_URI[sha256sum] = "e06ca111b2702d442f5cf70c754b6331cc7742231f0fe0b634cbd03c502610ba"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

RDEPENDS_${PN} += " \
        python-pbr \
        python-six \
        python-babel \
        python-cliff \
        python-keystoneauth1 \
        python-os-client-config \
        python-oslo.i18n \
        python-oslo.utils \
        python-simplejson \
        python-stevedore \
        "

CLEANBROKEN = "1"
