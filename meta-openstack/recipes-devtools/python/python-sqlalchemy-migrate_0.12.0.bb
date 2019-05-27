DESCRIPTION = "Database schema migration for SQLAlchemy"
HOMEPAGE = "http://code.google.com/p/sqlalchemy-migrate/"
SECTION = "devel/python"
LICENSE = "MIT & Apache-2.0"
LIC_FILES_CHKSUM = "file://setup.py;beginline=32;endline=32;md5=d41d8cd98f00b204e9800998ecf8427e"

inherit pypi

SRC_URI[md5sum] = "6a4920f2a2e07d193e95cf712d762b08"
SRC_URI[sha256sum] = "8cfada30bbcf79a83b3a2d1bcd637de7e1f43e390d54de33e4f3249fd9aacfae"

inherit setuptools

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python-pbr-native \
        "

RDEPENDS_${PN} += " \
        python-pbr \
        python-sqlalchemy \
        python-decorator \
        python-six \
        python-sqlparse \
        python-tempita \
        "
	
