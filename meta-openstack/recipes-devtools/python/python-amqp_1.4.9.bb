DESCRIPTION = "Low-level AMQP client for Python"
HOMEPAGE = "https://pypi.python.org/pypi/amqp/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1702a92c723f09e3fab3583b165a8d90"

SRCNAME = "amqp"

SRC_URI = "https://pypi.io/packages/source/a/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "df57dde763ba2dea25b3fa92dfe43c19"
SRC_URI[sha256sum] = "2dea4d16d073c902c3b89d9b96620fb6729ac0f7a923bbc777cb4ad827c0c61a"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
