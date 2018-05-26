DESCRIPTION = "OpenStack Profiler Library"
HOMEPAGE = "http://www.openstack.org/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=19cbd64715b51267a47bf3750cc6a8a5"

SRC_URI[md5sum] = "6762b5420fd95646a26c4eaca1af9e64"
SRC_URI[sha256sum] = "aee63cfd888e6049ea82535ce458ce4844b4ac893dcb18060eda24192505627e"

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
