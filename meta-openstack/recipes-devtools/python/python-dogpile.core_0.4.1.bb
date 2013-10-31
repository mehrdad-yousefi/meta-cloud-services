DESCRIPTION = "Python Dogpile Core: Dogpile is basically the locking code extracted from the Beaker package, for simple and generic usage."
HOMEPAGE = "https://pypi.python.org/pypi/dogpile.core"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0401fd56584d7b3d4be91690672ec433"

PR = "r0"
SRCNAME = "dogpile.core"

SRC_URI = "https://pypi.python.org/packages/source/d/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "5f76cce023d505a5375b07e094c3260f"
SRC_URI[sha256sum] = "af2555702811d56846778d39451cf822b04b3f13347080c121a4977fefdfcbff"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools


