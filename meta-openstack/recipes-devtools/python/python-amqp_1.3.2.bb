DESCRIPTION = "Low-level AMQP client for Python"
HOMEPAGE = "https://pypi.python.org/pypi/amqp/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1702a92c723f09e3fab3583b165a8d90"

PR = "r0"
SRCNAME = "amqp"

SRC_URI = "https://pypi.python.org/packages/source/a/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "0f15c0cd31bae0563107a22f17cfdf63"
SRC_URI[sha256sum] = "9d321609f98f6742eeb2f7d22334749936a26047af5563818e175444ad1e2ba4"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
