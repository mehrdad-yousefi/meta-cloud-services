DESCRIPTION = "%DESCRIPTION%"
HOMEPAGE = "%URL%"
SECTION = "devel/python"
LICENSE = "Apache-2"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=7de5500e6244db6d698bbb724aea9a17"

PYPI_PACKAGE = "XStatic-jquery-ui"

SRC_URI[md5sum] = "2d5569524c7936d82f41d833f3c84e62"
SRC_URI[sha256sum] = "d6ba48bb474420a8bcb2be02eef6ae96281ec24eff6befa54f04ebc9e4cc8910"

inherit setuptools3 pypi

# DEPENDS_default: python3-pip

DEPENDS += " \
        python3-pip \
        "

# RDEPENDS_default: 
RDEPENDS_${PN} += " \
        "
