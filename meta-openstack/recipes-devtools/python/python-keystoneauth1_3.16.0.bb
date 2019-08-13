DESCRIPTION = "Authentication Library for OpenStack Identity"
HOMEPAGE = "https://pypi.python.org/pypi/keystoneauth1"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=96f840d59b245a1c817fbcb901afc574"

SRC_URI[md5sum] = "4d2b56ac0b3d19eacb7f3a3198cfcc54"
SRC_URI[sha256sum] = "0465ed3e69ec0a148a5785f59f6fd3cece7808090cbcb90a2d2cb27ab360d9d7"

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
