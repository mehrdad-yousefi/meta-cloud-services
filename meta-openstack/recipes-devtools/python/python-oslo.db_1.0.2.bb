DESCRIPTION = "oslo.db library"
HOMEPAGE = "http://launchpad.net/oslo"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

PR = "r0"

SRCNAME = "oslo.db"
SRC_URI = "http://pypi.python.org/packages/source/o/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "2c7300e9f64b3ea54f56c9f04ff7d004"
SRC_URI[sha256sum] = "6ffdb57913fd56579d55b4154526b1e2a61d728b4c29b4dd7c0b8272c1ac2e1c"

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
