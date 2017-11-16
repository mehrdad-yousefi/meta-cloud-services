DESCRIPTION = "Python-PostgreSQL Database Adapter"
HOMEPAGE = "http://initd.org/psycopg/"
SECTION = "devel/python"
LICENSE = "GPLv3+"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2c9872d13fa571e7ba6de95055da1fe2"
DEPENDS = "postgresql"

SRC_URI += " \
           file://remove-pg-config.patch \
          "

SRC_URI[md5sum] = "4a392949ba31a378a18ed3e775a4693f"
SRC_URI[sha256sum] = "70490e12ed9c5c818ecd85d185d363335cc8a8cbf7212e3c185431c79ff8c05c"

inherit distutils pypi

DEPENDS += " \
    postgresql \
"
