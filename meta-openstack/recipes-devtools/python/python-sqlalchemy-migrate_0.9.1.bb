DESCRIPTION = "Database schema migration for SQLAlchemy"
HOMEPAGE = "http://code.google.com/p/sqlalchemy-migrate/"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://setup.py;beginline=32;endline=32;md5=d41d8cd98f00b204e9800998ecf8427e"

PR = "r0"
SRCNAME = "sqlalchemy-migrate"

SRC_URI = "https://pypi.python.org/packages/source/s/sqlalchemy-migrate/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "5f0237ed55041b9a831d4d18d0a46f53"
SRC_URI[sha256sum] = "16e327c9642ca4c99a70dcac3b39aeb821edaf5214834b47fb0a89bac44af23b"

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
