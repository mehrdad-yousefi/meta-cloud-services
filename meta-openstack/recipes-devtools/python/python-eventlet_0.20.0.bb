DESCRIPTION = "Highly concurrent networking library"
HOMEPAGE = "http://pypi.python.org/pypi/eventlet"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=56472ad6de4caf50e05332a34b66e778"

SRC_URI[md5sum] = "057276232bf65f1db6aabf819e7ece6a"
SRC_URI[sha256sum] = "2e17cda85f2003796f13de0e6c59a5253c0afd1f45dfc97bb9b6bfb8962f7895"

inherit setuptools pypi

RDEPENDS_${PN} += " \
    python-enum34 \
    python-greenlet \
    "
