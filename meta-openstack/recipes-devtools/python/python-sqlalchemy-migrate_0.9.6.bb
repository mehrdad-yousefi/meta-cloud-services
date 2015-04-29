DESCRIPTION = "Database schema migration for SQLAlchemy"
HOMEPAGE = "http://code.google.com/p/sqlalchemy-migrate/"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://setup.py;beginline=32;endline=32;md5=d41d8cd98f00b204e9800998ecf8427e"

SRCNAME = "sqlalchemy-migrate"

SRC_URI = "https://pypi.python.org/packages/source/s/sqlalchemy-migrate/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "1cdb4583dc30c436c4a060d08c764632"
SRC_URI[sha256sum] = "c2c73d8dbeb29a96459d8622e3bac2e97cf6f74ed0564469486fe7ffe0ef3d97"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

DEPENDS += " \
        python-pip \
        python-pbr \
        "

RDEPENDS_${PN} += "python-sqlalchemy  \
	python-decorator \
	python-tempita  \
        python-pbr \
    "
