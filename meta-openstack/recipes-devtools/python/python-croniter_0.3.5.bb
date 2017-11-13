DESCRIPTION = "croniter provides iteration for datetime object with cron like format"
HOMEPAGE = "https://pypi.python.org/pypi/croniter/0.3.4"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=2c82e6382ef84397e2341a04f039abcc"

# Archived version so we have to overwrite what the pypi class will derive
PYPI_SRC_URI = "https://pypi.python.org/packages/source/c/croniter/croniter-${PV}.zip"

SRC_URI[md5sum] = "63cf9e4d6778dc4102a4794a39a1b45b"
SRC_URI[sha256sum] = "ecd5cda855668ae11ed5ea341e9c2145bbab88bfd0763666951cfe15bab23f50"

inherit setuptools pypi

DEPENDS += " \
        python-pip \
        "

RDEPENDS_${PN} += " \
        python-dateutil \
        "
