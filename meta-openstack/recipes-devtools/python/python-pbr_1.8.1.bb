DESCRIPTION = "Python Build Reasonableness: PBR is a library that injects some useful and sensible default behaviors into your setuptools run"
HOMEPAGE = "https://pypi.python.org/pypi/pbr"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

SRCNAME = "pbr"

SRC_URI = "https://pypi.python.org/packages/source/p/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "c8f9285e1a4ca6f9654c529b158baa3a"
SRC_URI[sha256sum] = "e2127626a91e6c885db89668976db31020f0af2da728924b56480fc7ccf09649"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

# DEPENDS_default: python-pip

DEPENDS += " \
        python-pip \
        "

# RDEPENDS_default:
RDEPENDS_${PN} += " \
        "
