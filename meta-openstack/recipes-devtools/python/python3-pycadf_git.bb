DESCRIPTION = "CADF Library"
HOMEPAGE = "https://launchpad.net/pycadf"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c46f31914956e4579f9b488e71415ac8"

PV = "3.1.0+git${SRCPV}"
SRCREV = "2402013a8719873d65136fc283e1855166adbc26"

SRCNAME = "pycadf"
SRC_URI = "git://github.com/openstack/${SRCNAME}.git;branch=master;protocol=https"

S = "${WORKDIR}/git"

inherit setuptools3

FILES:${PN} += "${datadir}/etc/${SRCNAME}/* \
                /usr/etc/pycadf/** \
               "

DEPENDS += " \
        python3-pip \
        python3-pbr \
        "
# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python3-pbr-native \
        "

RDEPENDS:${PN} += " \
      python3-babel \
      python3-iso8601 \
      python3-netaddr \
      python3-posix-ipc \
      python3-pytz \
      python3-six \
      python3-webob \
      python3-pbr \
        "
