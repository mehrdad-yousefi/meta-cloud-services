DESCRIPTION = "bootswatch javascript library packaged for setuptools (easy_install) / pip."
HOMEPAGE = "https://pypi.python.org/pypi/XStatic-bootswatch"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRCNAME = "XStatic-bootswatch"
SRC_URI = "https://pypi.python.org/packages/source/X/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "b7c76560828274bdcfee3f5e6fc5a147"
SRC_URI[sha256sum] = "3c018cb0fdf591a520b2832a4ba8d8face633c765f29f9ccca8275b47be8aa94"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

DEPENDS += " \
        python-pip \
        "

RDEPENDS_${PN} += " \
        "
