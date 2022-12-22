DESCRIPTION = "A comprehensive, fast, pure Python memcached client"
HOMEPAGE = "https://github.com/Pinterest/pymemcache"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=efde6ee9f51b69abbdca7d447b0d1488"

PYPI_PACKAGE = "pymemcache"

SRC_URI[md5sum] = "f0da0618d828f67ff3e0742c9ace3cd7"
SRC_URI[sha256sum] = "47882ab1c7e5e1dea67df8aa9faf410ce82e606fd5f29501273a60ff61d7cc99"

inherit setuptools3 pypi

# DEPENDS_default: python3-pip

DEPENDS += " \
        ${PYTHON_PN}-pip \
        ${PYTHON_PN}-six-native \
        "

# RDEPENDS:default: 
RDEPENDS:${PN} += " \
        ${PYTHON_PN}-io \
        ${PYTHON_PN}-six \
        ${PYTHON_PN}-logging \
        "
