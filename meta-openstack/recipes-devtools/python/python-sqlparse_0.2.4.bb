DESCRIPTION = "Non-validating SQL parser module"
HOMEPAGE = "http://pypi.python.org/pypi/sqlparse"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2b136f573f5386001ea3b7b9016222fc"

SRC_URI[md5sum] = "8f753105167f35ea94ae6387e8af152f"
SRC_URI[sha256sum] = "ce028444cfab83be538752a2ffdb56bc417b7784ff35bb9a3062413717807dec"

export BUILD_SYS
export HOST_SYS

inherit setuptools pypi

# DEPENDS_default: python-pip

DEPENDS += " \
        "

# RDEPENDS_default: 
RDEPENDS_${PN} += " \
        "
