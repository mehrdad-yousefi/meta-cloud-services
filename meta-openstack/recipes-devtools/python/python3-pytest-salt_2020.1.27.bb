SUMMARY = "This pytest plugin will allow the Salt Daemons to be used in tests."
HOMEPAGE = "https://github.com/saltstack/pytest-salt"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=5da5421b61b52c332140da3f2e10e40a"

SRC_URI[md5sum] = "3d6e5d10f7c16abcfbc176b5dbb6ad36"
SRC_URI[sha256sum] = "fcc29c9e8208eda8955367c11607e72467a68564d5afbcf632b1dd6ecfbe55a1"

inherit pypi setuptools3

RDEPENDS:${PN} = " \
    ${PYTHON_PN}-pytest \
    ${PYTHON_PN}-pytest-tempdir \
    ${PYTHON_PN}-pytest-helpers-namespace \
    ${PYTHON_PN}-psutil \
    "
