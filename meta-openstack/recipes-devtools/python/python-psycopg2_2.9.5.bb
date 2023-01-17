DESCRIPTION = "Python-PostgreSQL Database Adapter"
HOMEPAGE = "http://initd.org/psycopg/"
SECTION = "devel/python"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=72bded22a37845c7d9dc3fd39d699a2d"
DEPENDS = "postgresql"

SRC_URI += " \
           file://remove-pg-config.patch \
          "

SRC_URI[md5sum] = "4abf11760cef67f3f43f62731ad130f6"
SRC_URI[sha256sum] = "920bf418000dd17669d2904472efeab2b20546efd0548139618f8fa305d1d7ad"

inherit setuptools3 pypi

DEPENDS += " \
    postgresql \
"
