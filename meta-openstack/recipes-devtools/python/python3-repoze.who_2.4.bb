DESCRIPTION = "An identification and authentication framework for WSGI"
HOMEPAGE = "http://repoze.org/"
SECTION = "devel/python"
LICENSE = "BSD-Modification"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=2c33cdbc6bc9ae6e5d64152fdb754292"

SRC_URI[md5sum] = "5dc3b549d968a64342f3b7196477c895"
SRC_URI[sha256sum] = "cf97450de3c8eb5c03b4037be75b018db91befab1094204e452a0b1c0f7a94a6"

inherit setuptools3 pypi

# DEPENDS_default: python3-pip

DEPENDS += " \
        ${PYTHON_PN}-pip \
        "

# RDEPENDS:default: 
RDEPENDS:${PN} += " \
    ${PYTHON_PN}-pip \
    ${PYTHON_PN}-zopeinterface \
    "
