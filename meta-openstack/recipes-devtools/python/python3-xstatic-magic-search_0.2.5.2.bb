DESCRIPTION = "An AngularJS directive that provides a UI for both faceted filtering and as-you-type filtering"
HOMEPAGE = "https://pypi.python.org/pypi/XStatic-Magic-Search"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=ed1f7d184ee839074df6b44c744de2c0"

PYPI_PACKAGE = "XStatic-Magic-Search"

SRC_URI[md5sum] = "7edce59ce76a326b618f74f797498451"
SRC_URI[sha256sum] = "e72fcf08e7806b60cb6b120fb712c8d221f3ba53c12a10995da01e16fa5360f5"

inherit setuptools3 pypi

DEPENDS += " \
        "

RDEPENDS:${PN} += " \
        "
