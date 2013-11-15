DESCRIPTION = "Useful extra bits for Python - things that should be in the standard library"
HOMEPAGE = "https://pypi.python.org/pypi/extras/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6d108f338b2f68fe48ac366c4650bd8b"

PR = "r0"
SRCNAME = "extras"

SRC_URI = "https://pypi.python.org/packages/source/e/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "03ce207391454db37279e78ce2112365"
SRC_URI[sha256sum] = "534ff6feefe1cd03984f444e6415aacc79c0a85f3b868ec41a2fd5003004c31e"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
