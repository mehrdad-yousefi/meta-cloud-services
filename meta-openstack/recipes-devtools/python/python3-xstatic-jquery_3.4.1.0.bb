DESCRIPTION = "jQuery javascript library packaged for setuptools (easy_install) / pip."
HOMEPAGE = "http://jquery.com/"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://README.txt;md5=af1f21066b501c7d9265fab0d5556ece"

PYPI_PACKAGE = "XStatic-jQuery"

SRC_URI[md5sum] = "8b7ace314d6780e159b2c03cd93a4b5b"
SRC_URI[sha256sum] = "3fccac7eb265f95430c62eb652cdaeb671785267c77413df926d9facd5825978"

inherit setuptools3 pypi

# DEPENDS_default: python3-pip

DEPENDS += " \
        ${PYTHON_PN}-pip \
        "

# RDEPENDS:default: 
RDEPENDS:${PN} += " \
        "
