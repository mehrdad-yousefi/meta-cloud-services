DESCRIPTION = "A high-level Python Web framework"
HOMEPAGE = "http://www.djangoproject.com/"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fa8608154dcdd4029ae653131d4b7365"

PR = "r0"
SRCNAME = "Django"

SRC_URI = "https://pypi.python.org/packages/source/D/${SRCNAME}/${SRCNAME}-${PV}.tar.gz \
"

#SRC_URI[md5sum] = "7465f6383264ba167a9a031d6b058bff"
#SRC_URI[sha256sum] = "885fadcbb8963c0ccda5d9d2cca792970b0289b4e662406b2de2b736ff46123d"

SRC_URI[md5sum] = "fac09e1e0f11bb83bb187d652a9be967"
SRC_URI[sha256sum] = "078bf8f8ab025ed79e41ed5cee145a64dffea638eb5c2928c8cd106720824416"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils 
