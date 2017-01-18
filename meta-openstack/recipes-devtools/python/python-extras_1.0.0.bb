DESCRIPTION = "Useful extra bits for Python - things that should be in the standard library"
HOMEPAGE = "https://pypi.python.org/pypi/extras/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6d108f338b2f68fe48ac366c4650bd8b"

PR = "r0"
SRCNAME = "extras"

SRC_URI = "https://pypi.python.org/packages/be/18/0b7283f0ebf6ad4bb6b9937538495eadf05ef097b102946b9445c4242636/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "3a63ad60cf8f0186c9e3a02f55ec5b14"
SRC_URI[sha256sum] = "132e36de10b9c91d5d4cc620160a476e0468a88f16c9431817a6729611a81b4e"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
