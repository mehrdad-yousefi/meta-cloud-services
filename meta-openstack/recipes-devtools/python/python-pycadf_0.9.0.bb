DESCRIPTION = "CADF Library"
HOMEPAGE = "https://launchpad.net/pycadf"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c46f31914956e4579f9b488e71415ac8"


SRCNAME = "pycadf"
SRC_URI = "http://pypi.python.org/packages/source/p/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "cadda6f685a31abf18a0efe40541fec8"
SRC_URI[sha256sum] = "3bda0f95b6defd0d0c6afc827617002ddd0688bed5ccc93a25965aa1d6b40094"

S = "${WORKDIR}/${SRCNAME}-${PV}"

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
