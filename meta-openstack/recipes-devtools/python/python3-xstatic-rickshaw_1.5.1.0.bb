DESCRIPTION = "Rickshaw JavaScript library packaged for setuptools3"
HOMEPAGE = "https://pypi.python.org/pypi/XStatic-Rickshaw"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=0048c87aa2dfc6c21a4516c06867ad67"

PYPI_PACKAGE = "XStatic-Rickshaw"

SRC_URI[md5sum] = "aef17022c8a0ea3d9e2da6237d5175ef"
SRC_URI[sha256sum] = "cf278d4bd4e974ddcf7170d20bbb706cc34f93cf61658f2f68f3138374178564"

inherit setuptools3 pypi

# DEPENDS_default: python3-pip

DEPENDS += " \
        python3-pip \
        "

# RDEPENDS:default: 
RDEPENDS:${PN} += " \
        "
