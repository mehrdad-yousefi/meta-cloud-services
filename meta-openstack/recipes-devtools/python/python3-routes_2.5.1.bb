DESCRIPTION = "A Python re-implementation of the Rails routes system."
HOMEPAGE = "http://routes.groovie.org"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=90976c1a0e3029278f882cfe2e84a6ae"

SRC_URI[sha256sum] = "b6346459a15f0cbab01a45a90c3d25caf980d4733d628b4cc1952b865125d053"

PYPI_PACKAGE = "Routes"

inherit setuptools3 pypi

RDEPENDS_${PN} += " \
	${PYTHON_PN}-netclient \	
	${PYTHON_PN}-six \	
	${PYTHON_PN}-repoze.lru \	
"
