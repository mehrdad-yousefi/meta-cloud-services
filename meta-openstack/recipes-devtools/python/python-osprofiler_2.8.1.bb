DESCRIPTION = "OpenStack Profiler Library"
HOMEPAGE = "http://www.openstack.org/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=19cbd64715b51267a47bf3750cc6a8a5"

SRC_URI[md5sum] = "ec8ef752caf49591941fba063ca40fb4"
SRC_URI[sha256sum] = "ee6d8a40daa3909b7c594378986b8c93ec2561dd8c329bad0aa54d4795c8fa57"

inherit setuptools pypi

# DEPENDS_default: python-pip

DEPENDS += " \
        python-pip \
        python-pbr \
        "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python-pbr-native \
        "

# RDEPENDS_default: 
RDEPENDS_${PN} += " \
        python-pbr \
        python-six \
        python-oslo.messaging \
        python-oslo.log \
        python-oslo.utils \
        python-webob \
        python-requests \
        python-netaddr \
        python-oslo.concurrency \
        "
