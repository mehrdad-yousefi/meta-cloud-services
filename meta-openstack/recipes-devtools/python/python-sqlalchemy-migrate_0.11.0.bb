DESCRIPTION = "Database schema migration for SQLAlchemy"
HOMEPAGE = "http://code.google.com/p/sqlalchemy-migrate/"
SECTION = "devel/python"
LICENSE = "MIT & Apache-2.0"
LIC_FILES_CHKSUM = "file://setup.py;beginline=32;endline=32;md5=d41d8cd98f00b204e9800998ecf8427e"

inherit pypi

SRC_URI[md5sum] = "f68c75280270f2fb2824633ef8633628"
SRC_URI[sha256sum] = "e68af5e3e0561f629d4eb23d9d0ea77d2649747f2eff37fd29aece74615ca251"

inherit setuptools

RDEPENDS_${PN} += " \
        python-pbr \
        python-sqlalchemy \
        python-decorator \
        python-six \
        python-sqlparse \
        python-tempita \
        "
	