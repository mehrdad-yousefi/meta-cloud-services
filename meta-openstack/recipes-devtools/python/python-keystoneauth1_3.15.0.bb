DESCRIPTION = "Authentication Library for OpenStack Identity"
HOMEPAGE = "https://pypi.python.org/pypi/keystoneauth1"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=96f840d59b245a1c817fbcb901afc574"

SRC_URI[md5sum] = "0f3e21362a74d1fb8959fc2bf7d28882"
SRC_URI[sha256sum] = "439f7dcf6edde5ea5a16ef90603d198e118a03f529aba0f8a6d19d5f6433de95"

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
