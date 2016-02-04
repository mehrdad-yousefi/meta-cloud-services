DESCRIPTION = "A Python re-implementation of the Rails routes system."
HOMEPAGE = "http://routes.groovie.org"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=aa6285dc7b7c93b3905bb2757f33eb62"

PV = "1.13+git${SRCPV}"
SRCREV = "467501d5fcfa265b3dfae615e7f0dcda8ce79d4e"

SRCNAME = "Routes"
SRC_URI = "git://github.com/bbangert/routes.git"

S = "${WORKDIR}/git"

inherit setuptools

RDEPENDS_${PN} += "python-repoze.lru"
