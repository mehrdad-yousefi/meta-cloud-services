DESCRIPTION = "A python package that provides useful locks."
HOMEPAGE = "https://github.com/harlowja/fasteners"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4476c4be31402271e101d9a4a3430d52"

SRCNAME = "fasteners"

PV = "0.13.0+git${SRCPV}"
SRCREV = "c055890c98f67c343ff445973cd4efee67f081ce"

SRC_URI = "git://github.com/harlowja/${SRCNAME}.git"

S = "${WORKDIR}/git"

inherit setuptools

DEPENDS += " \
        python-pip \
        python-pbr \
        "

# RDEPENDS_default:
RDEPENDS_${PN} += " \
        python-pbr \
        "
