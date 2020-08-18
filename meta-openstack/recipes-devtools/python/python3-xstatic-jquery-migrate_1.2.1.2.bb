DESCRIPTION = "JQuery-Migrate JavaScript library packaged for setuptools"
HOMEPAGE = "https://pypi.python.org/pypi/XStatic-JQuery-Migrate"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=55fddf010d3daf1956396fa50e27c864"

PYPI_PACKAGE = "XStatic-JQuery-Migrate"

SRC_URI[md5sum] = "7ade6ebf832a62e45b0096a1799a1bfc"
SRC_URI[sha256sum] = "db9d28cb161626f979f7999f158a4a7aaf6dc957fd0106b1ad1051d47969c425"

inherit setuptools3 pypi

# DEPENDS_default: python3-pip

DEPENDS += " \
        ${PYTHON_PN}-pip \
        "

# RDEPENDS_default: 
RDEPENDS_${PN} += " \
        "
