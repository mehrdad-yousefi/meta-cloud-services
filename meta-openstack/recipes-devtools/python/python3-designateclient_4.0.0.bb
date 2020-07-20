DESCRIPTION = "Python bindings to the Designate API"
HOMEPAGE = "https://github.com/openstack/python-designateclient"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

DEPENDS += " \
        python3-pip \
        python3-pbr \
        "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python3-pbr-native \
        "
SRC_URI[md5sum] = "ad4ca221c5209261cf0eaf2824b07b55"
SRC_URI[sha256sum] = "d61e7999f0cbb55d2b6e7dec7a6232389d3034de27c1e80b7d5c69d60dd58dbf"

RDEPENDS_${PN} += " \
        python3-cliff \
        python3-jsonschema \
        python3-osc-lib \
        python3-oslo.utils \
        python3-pbr \
        python3-keystoneauth1 \
        python3-requests \
        python3-six \
        python3-stevedore \
        python3-debtcollector \
        "

PYPI_PACKAGE = "python-designateclient"

inherit setuptools3 pypi
