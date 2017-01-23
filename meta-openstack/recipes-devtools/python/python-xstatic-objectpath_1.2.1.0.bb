DESCRIPTION = "objectpath packaged for setuptools (easy_install) / pip."
HOMEPAGE = "https://pypi.python.org/pypi/XStatic-objectpath"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=98f106ed7f6916011689fc3699a6dabd"

SRCNAME = "XStatic-objectpath"
SRC_URI = "http://pypi.io/packages/source/X/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "680a5e23a3d362db0b0721e5620dd6fc"
SRC_URI[sha256sum] = "cd1e9f502482afcdd028821148843b07b4065c8dcea8e5cc33abb9ae1cf20b20"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

# DEPENDS_default: python-pip

DEPENDS += " \
        python-pip \
        "

# RDEPENDS_default: 
RDEPENDS_${PN} += " \
        "
