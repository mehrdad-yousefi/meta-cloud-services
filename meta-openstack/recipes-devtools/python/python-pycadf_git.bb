DESCRIPTION = "CADF Library"
HOMEPAGE = "https://launchpad.net/pycadf"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c46f31914956e4579f9b488e71415ac8"

PV = "1.1.0+git${SRCPV}"
SRCREV = "c5dc0d9577e455f149edb5331a6e493def6928d5"

SRCNAME = "pycadf"
SRC_URI = "git://github.com/openstack/${SRCNAME}.git"

S = "${WORKDIR}/git"

inherit setuptools

FILES_${PN} += "${datadir}/etc/${SRCNAME}/*"

DEPENDS += " \
        python-pip \
        python-pbr \
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
