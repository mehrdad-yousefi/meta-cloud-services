DESCRIPTION = "CADF Library"
HOMEPAGE = "https://launchpad.net/pycadf"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c46f31914956e4579f9b488e71415ac8"

PR = "r0"

SRCNAME = "pycadf"
SRC_URI = "http://pypi.python.org/packages/source/p/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "0386d95acb2045231fbcbe12fcaa2779"
SRC_URI[sha256sum] = "3f88f1c5ea7db093261afb2fd5a235b3dff540d9e93fde5a01a577222b33723c"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

FILES_${PN} += "${datadir}/etc/${SRCNAME}/*"

DEPENDS += " \
        python-pip \
        "

RDEPENDS_${PN} += " \
      python-babel \
      python-iso8601 \
      python-netaddr \
      python-posix-ipc \
      python-pytz \
      python-six \
      python-webob \
        "
