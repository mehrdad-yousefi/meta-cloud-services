DESCRIPTION = "JQuery.TableSorter JavaScript library packaged for setuptools3"
HOMEPAGE = "https://pypi.python.org/pypi/XStatic-JQuery.TableSorter"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=e9d3f27b721fc196b019f8afb6f639a0"

PYPI_PACKAGE = "XStatic-JQuery.TableSorter"

SRC_URI[md5sum] = "024a8dd83aa173ec0b161e76391ba56c"
SRC_URI[sha256sum] = "bdd847ca0cde4014fd21134f99e59a99ef488185c745e82646911d2f9de3d762"

inherit setuptools3 pypi

# DEPENDS_default: python3-pip

DEPENDS += " \
        python3-pip \
        "

# RDEPENDS:default: 
RDEPENDS:${PN} += " \
        "
