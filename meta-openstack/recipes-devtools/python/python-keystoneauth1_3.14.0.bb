DESCRIPTION = "Authentication Library for OpenStack Identity"
HOMEPAGE = "https://pypi.python.org/pypi/keystoneauth1"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=96f840d59b245a1c817fbcb901afc574"

SRC_URI[md5sum] = "ada9836933f5aa6bd35faf01c314e81d"
SRC_URI[sha256sum] = "b14f363d02142177c968cfffeb9eb37113682c03ac3c65d483424e203dd602c3"

inherit setuptools pypi

DEPENDS += " \
        python-pbr \
        "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python-pbr-native \
        "

RDEPENDS_${PN} += " \
        python-pbr \
        python-iso8601 \
        python-requests \
        python-six \
        python-stevedore \
        "
