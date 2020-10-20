DESCRIPTION = "Simplify the writing of REST APIs, and extend them with additional protocols"
HOMEPAGE = "https://pypi.python.org/pypi/WSME/"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5a9126e7f56a0cf3247050de7f10d0f4"

PYPI_PACKAGE = "WSME"

SRC_URI[md5sum] = "7e5d5c6dbee2ad1e82c518ef3bfdf108"
SRC_URI[sha256sum] = "965b9ce48161e5c50d84aedcf50dca698f05bf07e9d489201bccaec3141cd304"

DEPENDS += " \
        ${PYTHON_PN}-pip \
        ${PYTHON_PN}-pbr \
        "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        ${PYTHON_PN}-pbr-native \
        "

RDEPENDS_${PN} += "\
        ${PYTHON_PN}-pbr \
        ${PYTHON_PN}-six \
        ${PYTHON_PN}-pytz \
        ${PYTHON_PN}-netaddr \
        ${PYTHON_PN}-webob \
        "

inherit setuptools3 pypi
