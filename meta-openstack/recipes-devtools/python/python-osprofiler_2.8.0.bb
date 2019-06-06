DESCRIPTION = "OpenStack Profiler Library"
HOMEPAGE = "http://www.openstack.org/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=19cbd64715b51267a47bf3750cc6a8a5"

SRC_URI[md5sum] = "c48561c6c6d2112d5b06d5c4af581790"
SRC_URI[sha256sum] = "56f8717c1c30193706ea6f9959f5f289edee910f90ebd763db38cfbd9c1c90d4"

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
