DESCRIPTION = "CADF Library"
HOMEPAGE = "https://launchpad.net/pycadf"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c46f31914956e4579f9b488e71415ac8"

PV = "2.9.0+git${SRCPV}"
SRCREV = "4398b7d34e40f250a42e2ba537ca995a8c37376d"

SRCNAME = "pycadf"
SRC_URI = "git://github.com/openstack/${SRCNAME}.git"

S = "${WORKDIR}/git"

inherit setuptools

FILES_${PN} += "${datadir}/etc/${SRCNAME}/*"

DEPENDS += " \
        python-pip \
        python-pbr \
        "
# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python-pbr-native \
        "

RDEPENDS_${PN} += " \
      python-babel \
      python-iso8601 \
      python-netaddr \
      python-posix-ipc \
      python-pytz \
      python-six \
      python-webob \
      python-pbr \
        "
