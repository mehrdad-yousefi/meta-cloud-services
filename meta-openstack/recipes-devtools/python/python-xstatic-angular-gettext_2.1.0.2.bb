DESCRIPTION = "Angular-Gettext javascript library packaged for setuptools (easy_install) / pip."
HOMEPAGE = "https://pypi.python.org/pypi/XStatic-Angular-Gettext"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=46d1a7b9d85c18f6acc979ab4e2ae6d9"

SRCNAME = "XStatic-Angular-Gettext"
SRC_URI = "https://pypi.python.org/packages/source/X/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "371919adc1c6d6a45085f8a006b44efa"
SRC_URI[sha256sum] = "c0745f433bb2f87d8222cdd65690c9089f5128c736309c3bc8d689aec39fa493"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

DEPENDS += " \
        python-pip \
        "

RDEPENDS_${PN} += " \
        "
