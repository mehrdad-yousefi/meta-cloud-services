DESCRIPTION = "MessagePack (de)serializer"
HOMEPAGE = "https://pypi.python.org/pypi/msgpack-python/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=cd9523181d9d4fbf7ffca52eaa2a5751"

PR = "r0"
SRCNAME = "msgpack-python"

SRC_URI = "https://pypi.python.org/packages/source/m/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "8b9ce43619fd1428bf7baddf57e38d1a"
SRC_URI[sha256sum] = "d078094f0b29b2b93cb96a76febc70fbe90ae4eb131ff60a6dc038edda92c278"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
