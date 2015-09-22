DESCRIPTION = "oslo.db library"
HOMEPAGE = "http://launchpad.net/oslo"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"


SRCNAME = "oslo.db"
SRC_URI = "http://pypi.python.org/packages/source/o/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "1ab1e83d18761b8411f44983ae749da1"
SRC_URI[sha256sum] = "028ed6a38c1ed6d39d04f3dc2d7b7e2e0aca3cf53e72e145c3c07a5a0fb80eb8"

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
