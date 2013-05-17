DESCRIPTION = "Database schema migration for SQLAlchemy"
HOMEPAGE = "http://code.google.com/p/sqlalchemy-migrate/"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://setup.py;beginline=32;endline=32;md5=cb374f131a90bccb0afff3d7ede94569"

PR = "r0"
SRCNAME = "sqlalchemy-migrate"

SRC_URI = "http://sqlalchemy-migrate.googlecode.com/files/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "10382fda16f056491e671b5307dd6713"
SRC_URI[sha256sum] = "7f55c768ee26f143fedb11b365a4c57c3bbdb5211e049c7f04b8ae8107c28333"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

RDEPENDS_${PN} += "python-sqlalchemy  \
	python-decorator \
	python-tempita  \
    "
