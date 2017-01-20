DESCRIPTION = "Simplify the writing of REST APIs, and extend them with additional protocols"
HOMEPAGE = "https://pypi.python.org/pypi/WSME/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5a9126e7f56a0cf3247050de7f10d0f4"

SRCNAME = "WSME"

SRC_URI = "https://pypi.python.org/packages/8d/c5/0d0ba34f228aa1b5512cbfa833aba24755523ed2eca3ece043702ea19911/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "23b0269af3f4c1db8cfa35054703f0db"
SRC_URI[sha256sum] = "afdd3ba14f815837239d6dead652de460bd61a869e39430b459be77d1a928197"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

DEPENDS += " \
        python-pip \
        python-pbr \
        "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python-pbr-native \
        "

RDEPENDS_${PN} += "\
        python-pbr \
        "
