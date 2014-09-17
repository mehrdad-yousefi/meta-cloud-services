DESCRIPTION = "Font Awesome icons packaged for setuptools (easy_install) / pip."
HOMEPAGE = "https://pypi.python.org/pypi/XStatic-Font-Awesome"
SECTION = "devel/python"
LICENSE = "Apache-2"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=faab18144d8e4d0230ad3fd6f3764d22"

PR = "r0"

SRCNAME = "XStatic-Font-Awesome"
SRC_URI = "http://pypi.python.org/packages/source/X/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "84965a23e6f98e2e50df5386b85e0f6e"
SRC_URI[sha256sum] = "620cc5224358b8bdb214ecf3c4e8aa9ea3b538ff38624d54e609b52e77f8caea"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

# DEPENDS_default: python-pip

DEPENDS += " \
        python-pip \
        "

# RDEPENDS_default: 
RDEPENDS_${PN} += " \
        "
