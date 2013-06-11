DESCRIPTION = "A database migration tool for SQLAlchemy."
HOMEPAGE = "http://bitbucket.org/zzzeek/alembic"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8a916dc02872b4ca467ca1aeaf9516ef"

PR = "r0"
SRCNAME = "alembic"

SRC_URI = "https://pypi.python.org/packages/source/a/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "e22d10fd885473eccc9c8c75238e97ce"
SRC_URI[sha256sum] = "9d6dfd094c405f2d53882624a34e78838a27e22be25d809a1dffce1f9cd64e93"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools 

RDEPENDS_${PN} += "python-sqlalchemy"

