DESCRIPTION = "Highly concurrent networking library"
HOMEPAGE = "http://pypi.python.org/pypi/eventlet"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=56472ad6de4caf50e05332a34b66e778"

PR = "r0"
SRCNAME = "eventlet"

SRC_URI = "http://pypi.python.org/packages/source/e/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "3718973195adb36bbf6626be370e7f47"
SRC_URI[sha256sum] = "aaf97960b7e00f36844549399a22746c7ef27d76fffcd4056fb36bd242dd1e47"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
