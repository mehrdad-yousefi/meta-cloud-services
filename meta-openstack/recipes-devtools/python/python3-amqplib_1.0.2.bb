DESCRIPTION = "Python client for the Advanced Message Queuing Procotol (AMQP)"
HOMEPAGE = "http://code.google.com/p/py-amqplib/"
SECTION = "devel/python"
LICENSE = "LGPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1702a92c723f09e3fab3583b165a8d90"

PR = "r1"
SRCNAME = "amqplib"

SRC_URI = "https://github.com/barryp/py-amqplib/archive/${PV}.tar.gz"

SRC_URI[md5sum] = "2a705976787612991ee9da32f0ba638d"
SRC_URI[sha256sum] = "ef370cdbf9b83b2efa685f6010a0a712a1bc60a3d82e1206a073110b898ef338"

S = "${WORKDIR}/py-amqplib-${PV}"

inherit setuptools3
