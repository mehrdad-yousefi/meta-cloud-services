DESCRIPTION = "OpenStackClient Library"
HOMEPAGE = "http://opensource.perlig.de/rcssmin/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

SRC_URI[md5sum] = "8bae654318c8c82d341f7228cfa3ec2d"
SRC_URI[sha256sum] = "7dee72f13e5478f8d3d836267fa019b99ed4d5e478fc08bbcc9e23029d11ec78"

inherit setuptools pypi

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
