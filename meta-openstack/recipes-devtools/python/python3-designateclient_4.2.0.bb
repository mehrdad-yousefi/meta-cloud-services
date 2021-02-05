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
SRC_URI[md5sum] = "51e6aaf70e253c999824c7bc29009f5e"
SRC_URI[sha256sum] = "cf0e76540530491a6100164c514e1c60b55efa25c8db4c18f4902c988d7c1080"

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
