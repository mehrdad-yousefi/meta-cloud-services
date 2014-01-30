DESCRIPTION = "Database schema migration for SQLAlchemy"
HOMEPAGE = "http://code.google.com/p/sqlalchemy-migrate/"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://setup.py;beginline=32;endline=32;md5=d41d8cd98f00b204e9800998ecf8427e"

PR = "r0"
SRCNAME = "sqlalchemy-migrate"

SRC_URI = "https://pypi.python.org/packages/source/s/sqlalchemy-migrate/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "04b360fa0f887e47470dcdfb0d7f4e1c"
SRC_URI[sha256sum] = "27a3ffce6a753e1e787f4f576e54ee240fa95abd02428638fa285eaaa3cbd22c"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

RDEPENDS_${PN} += "python-sqlalchemy  \
	python-decorator \
	python-tempita  \
    "
