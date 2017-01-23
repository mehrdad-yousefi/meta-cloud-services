DESCRIPTION = "mdi javascript library packaged for setuptools (easy_install) / pip."
HOMEPAGE = "https://pypi.python.org/pypi/XStatic-mdi"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=898ae9ca7b59edc4521f10be07c6b622"

SRCNAME = "XStatic-mdi"
SRC_URI = "https://pypi.io/packages/source/X/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "f3d3d58603178e5898ee1ea4737826ee"
SRC_URI[sha256sum] = "19b4d522f8fa62fee2893b39147fcf45ebaba8b95d63f3708ebdf34e130a8a53"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

DEPENDS += " \
        python-pip \
        "

RDEPENDS_${PN} += " \
        "
