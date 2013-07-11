DESCRIPTION = "A high-level Python Web framework"
HOMEPAGE = "http://www.djangoproject.com/"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fa8608154dcdd4029ae653131d4b7365"

PR = "r0"
SRCNAME = "Django"

SRC_URI = "https://pypi.python.org/packages/source/D/${SRCNAME}/${SRCNAME}-${PV}.tar.gz \
"

SRC_URI[md5sum] = "851d00905eb70e4aa6384b3b8b111fb7"
SRC_URI[sha256sum] = "0e1e8c4217299672bbf9404994717fca2d8d4b7a4f7b8b3b74d413e1fda81428"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

FILES_${PN} += "${datadir}/django/*"

