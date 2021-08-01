DESCRIPTION = "Python binding for the PowerVM REST API"
HOMEPAGE = "https://pypi.python.org/pypi/pypowervm"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

SRC_URI[md5sum] = "50b580055e5628aadaeb42fd69158ff8"
SRC_URI[sha256sum] = "4c6bf225d2b1022b5d363f9b3695fd1692523235d3ce1b5b4506fbc608bdb535"

inherit setuptools3 pypi

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python3-pbr-native \
	"

RDEPENDS:${PN} += " \
        python3-lxml \
        python3-oslo.concurrency \
        python3-oslo.context \
        python3-oslo.i18n \
        python3-oslo.log \
        python3-oslo.utils \
        python3-pbr \
        python3-pyasn1-modules \
        python3-pyasn1 \
        python3-pytz \
        python3-requests \
        python3-six \
        python3-taskflow \
        python3-networkx \
        "
