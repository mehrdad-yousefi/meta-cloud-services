DESCRIPTION = "OpenStack Profiler Library"
HOMEPAGE = "http://www.openstack.org/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=19cbd64715b51267a47bf3750cc6a8a5"

SRC_URI[md5sum] = "691c4d2cc77e60eeaa30edd7bf087481"
SRC_URI[sha256sum] = "f7fe387f4dd681bbf92b9fbe857cc90e89cfe96d44522a2727540902310a9ed6"

inherit setuptools3 pypi

# DEPENDS_default: python3-pip

DEPENDS += " \
        python3-pip \
        python3-pbr \
        "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python3-pbr-native \
        "

# RDEPENDS:default: 
RDEPENDS:${PN} += " \
        python3-pbr \
        python3-six \
        python3-oslo.messaging \
        python3-oslo.log \
        python3-oslo.utils \
        python3-webob \
        python3-requests \
        python3-netaddr \
        python3-oslo.concurrency \
        "
