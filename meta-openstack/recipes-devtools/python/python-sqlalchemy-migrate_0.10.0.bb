DESCRIPTION = "Database schema migration for SQLAlchemy"
HOMEPAGE = "http://code.google.com/p/sqlalchemy-migrate/"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://setup.py;beginline=32;endline=32;md5=d41d8cd98f00b204e9800998ecf8427e"

SRCNAME = "sqlalchemy-migrate"

SRC_URI = "https://pypi.python.org/packages/source/s/sqlalchemy-migrate/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "af20c212b3379c142a1b3f66bb39b6d8"
SRC_URI[sha256sum] = "f83c5cce9c09e5c05527279b7fe1565b32e5353342ff30b24f594fa2e5a7e003"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

DEPENDS += " \
        python-pip \
        python-pbr \
        "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python-pbr-native \
        "

RDEPENDS_${PN} += "python-sqlalchemy  \
	python-decorator \
	python-tempita  \
        python-pbr \
    "
