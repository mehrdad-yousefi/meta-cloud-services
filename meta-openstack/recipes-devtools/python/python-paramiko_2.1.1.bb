DESCRIPTION = "SSH2 protocol library"
HOMEPAGE = "https://github.com/paramiko/paramiko/"
SECTION = "devel/python"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fd0120fc2e9f841c73ac707a30389af5"

PR = "r0"
SRCNAME = "paramiko"

SRC_URI = "https://pypi.python.org/packages/d1/5a/ebd00d884f30baf208359a027eb7b38372d81d0c004724bb1aa71ae43b37/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "9e8abe635baa6bb75a4cd55dcb56a264"
SRC_URI[sha256sum] = "d51dada7ad0736c116f8bfe3263627925947e4a50e61436a83d58bfe7055b575"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

RDEPENDS_${PN} += "python-pycrypto"
