DESCRIPTION = "croniter provides iteration for datetime object with cron like format"
HOMEPAGE = "https://pypi.python.org/pypi/croniter/0.3.4"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=21cc5101d5b0c940e3354fb1bd26c7e5"

# Archived version so we have to overwrite what the pypi class will derive
PYPI_SRC_URI = "https://pypi.python.org/packages/source/c/croniter/croniter-${PV}.tar.gz"

SRC_URI[md5sum] = "f5543f9f165fe725b2133b698f520380"
SRC_URI[sha256sum] = "fbd72189a0ff38c27e953d15175c5fedafb953479559240a1afcf8e8e7523757"

inherit setuptools pypi

DEPENDS += " \
        python-pip \
        "

RDEPENDS_${PN} += " \
        python-dateutil \
        "
