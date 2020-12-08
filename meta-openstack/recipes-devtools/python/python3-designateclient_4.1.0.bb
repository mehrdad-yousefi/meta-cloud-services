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
SRC_URI[md5sum] = "29f1ebf4352162e4e8d3a6d6f9ab1eb4"
SRC_URI[sha256sum] = "a5b800d767d6626057e1cefd0c6a35936ba5009e822d5b0df05aaa6ae7efaab9"

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
