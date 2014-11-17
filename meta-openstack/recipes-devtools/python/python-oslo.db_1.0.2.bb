DESCRIPTION = "oslo.db library"
HOMEPAGE = "http://launchpad.net/oslo"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

PR = "r0"

SRCNAME = "oslo.db"
SRC_URI = "http://pypi.python.org/packages/source/o/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "6c87294ce18252bef17e2552bc19a40c"
SRC_URI[sha256sum] = "7092525eab0352748fc0c58a7facd3d6ae967d9130589b4afc12bfa171bee837"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

DEPENDS += " \
        python-pip \
        "

RDEPENDS_${PN} += " \
       python-alembic \
       python-babel \
       python-iso8601 \
       python-lockfile \
       python-oslo.config \
       python-sqlalchemy \
       python-sqlalchemy-migrate \
       python-stevedore \
        "
