DESCRIPTION = "Authentication Library for OpenStack Identity"
HOMEPAGE = "https://pypi.python.org/pypi/keystoneauth1"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=96f840d59b245a1c817fbcb901afc574"

SRC_URI[md5sum] = "d3f93a071551a753218fd50d9f680ee6"
SRC_URI[sha256sum] = "768036ee66372df2ad56716b8be4965cef9a59a01647992919516defb282e365"

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
