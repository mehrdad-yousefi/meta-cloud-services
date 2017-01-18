DESCRIPTION = "Low-level AMQP client for Python"
HOMEPAGE = "https://pypi.python.org/pypi/amqp/"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9d6ba772ac59c08a25a12ce15bd5f27b"

SRCNAME = "amqp"

SRC_URI = "https://pypi.python.org/packages/23/39/06bb8bd31e78962675f696498f7821f5dbd11aa0919c5a811d83a0e02609/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "035a475e42ef4f431b4e0dca113434bd"
SRC_URI[sha256sum] = "1378cc14afeb6c2850404f322d03dec0082d11d04bdcb0360e1b10d4e6e77ef9"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
