SUMMARY = "Python lightweight in-process concurrent programming"
HOMEPAGE = "http://pypi.python.org/pypi/greenlet"
SECTION = "devel/python"
LICENSE = "MIT & PSF"
LIC_FILES_CHKSUM = "file://LICENSE;md5=03143d7a1a9f5d8a0fee825f24ca9c36 \
                    file://LICENSE.PSF;md5=c106931d9429eda0492617f037b8f69a"
SRC_URI = "http://pypi.python.org/packages/source/g/greenlet/greenlet-${PV}.tar.gz"
SRC_URI[md5sum] = "00bb1822d8511cc85f052e89d1fd919b"
SRC_URI[sha256sum] = "79f9b8bbbb1c599c66aed5e643e8b53bae697cae46e0acfc4ee461df48a90012"

S = "${WORKDIR}/greenlet-${PV}"

inherit distutils

