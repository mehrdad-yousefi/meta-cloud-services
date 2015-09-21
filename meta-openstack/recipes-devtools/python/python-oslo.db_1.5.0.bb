DESCRIPTION = "oslo.db library"
HOMEPAGE = "http://launchpad.net/oslo"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

PR = "r0"

SRCNAME = "oslo.db"
SRC_URI = "http://pypi.python.org/packages/source/o/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "b5786f249c3af5a45e39fcb495ef62f1"
SRC_URI[sha256sum] = "1358218c8055226e6a11aca521e46f7e0e13174b2ff4ae0503b372def10cd26e"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

DEPENDS += " \
        python-pip \
        python-pbr \
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
       python-pbr \
        "
