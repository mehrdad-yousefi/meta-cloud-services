DESCRIPTION = "WebSockets support for any application/server"
HOMEPAGE = "https://github.com/kanaka/websockify"
SECTION = "devel/python"
LICENSE = "LGPLv3"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=a3b5f97c9d64189899b91b3728bfd774"

PR = "r0"
SRCNAME = "websockify"

SRC_URI = "http://pypi.python.org/packages/source/w/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "cdee6d6754c85814e1e6dcdef18b9785"
SRC_URI[sha256sum] = "e48d5c790c9ce5ac938d76fd0a9019aad2a33401fb1702b6b84263959f64522b"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

RDEPENDS_${PN} += "gmp"

FILES_${PN} += "${datadir}/*"
