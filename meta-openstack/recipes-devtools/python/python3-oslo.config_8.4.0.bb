DESCRIPTION = "API supporting parsing command line arguments and .ini style configuration files."
HOMEPAGE = "https://pypi.python.org/pypi/oslo.config/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c46f31914956e4579f9b488e71415ac8"

SRC_URI[sha256sum] = "537d62c581de2227aebfc4c71ee6fb455b853be920e0b30b65ebbe8d8128725c"

inherit setuptools3 pypi

DEPENDS += " \
        python3-pbr \
        python3-pbr-native \
        python3-pip \
        "

RDEPENDS_${PN} += " \
    python3-requests \
    python3-netaddr \
    python3-stevedore \
    python3-debtcollector \
    python3-oslo.i18n \
    python3-rfc3986 \
    python3-pyyaml \
    "
	
