DESCRIPTION = "mdi javascript library packaged for setuptools3 (easy_install) / pip."
HOMEPAGE = "https://pypi.python.org/pypi/XStatic-mdi"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=af9320964a0ddf3bd33eccd79c29f964"

PYPI_PACKAGE = "XStatic-mdi"

SRC_URI[md5sum] = "aa720e603fce607681cc69989fbd41a9"
SRC_URI[sha256sum] = "be1005af7a593b0b3a349aadb05e4160ea65894248a47b246c6658345e2f10c1"

inherit setuptools3 pypi

DEPENDS += " \
        python3-pip \
        "

RDEPENDS_${PN} += " \
        "
