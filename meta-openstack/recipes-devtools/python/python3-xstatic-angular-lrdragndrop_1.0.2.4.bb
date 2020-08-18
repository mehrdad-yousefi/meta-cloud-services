DESCRIPTION = "LrDragNDrop javascript library packaged for setuptools3"
HOMEPAGE = "https://pypi.python.org/pypi/XStatic-Angular-lrdragndrop"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=a1d98e7268455ffeb218786128e982dd"

PYPI_PACKAGE = "XStatic-Angular-lrdragndrop"

SRC_URI[md5sum] = "6c6c7969bfa89701db2b316162b36291"
SRC_URI[sha256sum] = "5d3cce15a6342814811ddc372c6035bf4026253664c0b72a660b481cb183ae1b"

inherit setuptools3 pypi

DEPENDS += " \
        python3-pip \
        "

RDEPENDS_${PN} += " \
        "
