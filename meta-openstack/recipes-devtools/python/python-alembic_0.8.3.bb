DESCRIPTION = "A database migration tool for SQLAlchemy."
HOMEPAGE = "http://bitbucket.org/zzzeek/alembic"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8faea05c89b6ff4ad5a9fa082f540719"

SRCNAME = "alembic"

SRC_URI = "https://pypi.python.org/packages/source/a/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "2e4ef17675316af9f09d749b0aee390e"
SRC_URI[sha256sum] = "eeac36589c1bf393e2040de01514a0d101ef17039957300209b0b44f3ddffce9"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools 

RDEPENDS_${PN} += " \
    python-sqlalchemy \
    python-python-editor \
    "

