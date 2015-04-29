DESCRIPTION = "Python implementation of SAML Version 2 to be used in a WSGI environment"
HOMEPAGE = "https://github.com/rohe/pysaml2"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=64573b44c7c80d328f0c1a830b44df84"


SRCNAME = "pysaml2"
SRC_URI = "http://pypi.python.org/packages/source/p/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "9045eb4bd58f6f647de3dd33fe6dfa29"
SRC_URI[sha256sum] = "a26804150ddc5da803d0df4b7026b613a3571c387fd6d107f6263aabf2c84ec6"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

DEPENDS += " \
        python-pip \
        "

RDEPENDS_${PN} += " \
        "
