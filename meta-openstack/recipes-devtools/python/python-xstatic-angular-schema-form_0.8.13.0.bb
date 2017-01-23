DESCRIPTION = "Angular Schema Form packaged for setuptools (easy_install) / pip."
HOMEPAGE = "https://pypi.python.org/pypi/XStatic-Angular-Schema-Form"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=0e4430cb0dfdb98d3008c66d8339f31a"

SRCNAME = "XStatic-Angular-Schema-Form"
SRC_URI = "http://pypi.io/packages/source/X/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "d0faab81c36f4cfc03e092fedc30018d"
SRC_URI[sha256sum] = "7c08634901751267fe26d266fc027cf6ed2e5f422696985cec750594b3f4e300"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

# DEPENDS_default: python-pip

DEPENDS += " \
        python-pip \
        "

# RDEPENDS_default: 
RDEPENDS_${PN} += " \
        "
