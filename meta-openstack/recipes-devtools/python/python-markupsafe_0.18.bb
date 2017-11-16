DESCRIPTION = "Implements a XML/HTML/XHTML Markup safe string for Python"
HOMEPAGE = "http://github.com/mitsuhiko/markupsafe"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c6d1adcf45d69359f256c1cea3254127"

PYPI_PACKAGE = "MarkupSafe"

SRC_URI[md5sum] = "f8d252fd05371e51dec2fe9a36890687"
SRC_URI[sha256sum] = "b7d5d688bdd345bfa897777d297756688cf02e1b3742c56885e2e5c2b996ff82"

inherit setuptools pypi

RDEPENDS_${PN} += "python-re"

