DESCRIPTION = "mdi javascript library packaged for setuptools (easy_install) / pip."
HOMEPAGE = "https://pypi.python.org/pypi/XStatic-mdi"
SECTION = "devel/python"
LICENSE = "CC-BY-4.0"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=f056788d254e428803e2d2a93e6a510d"

SRCNAME = "XStatic-mdi"
SRC_URI = "https://pypi.python.org/packages/source/X/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "41a92868ff0fcbd86a912ca974b995bd"
SRC_URI[sha256sum] = ""

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

DEPENDS += " \
        python-pip \
        "

RDEPENDS_${PN} += " \
        "
