DESCRIPTION = "Python-PostgreSQL Database Adapter"
HOMEPAGE = "http://initd.org/psycopg/"
SECTION = "devel/python"
LICENSE = "GPLv3+"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2c9872d13fa571e7ba6de95055da1fe2"
DEPENDS = "postgresql"

PR = "r0"
SRCNAME = "psycopg2"

SRC_URI = "https://pypi.python.org/packages/7b/a8/dc2d50a6f37c157459cd18bab381c8e6134b9381b50fbe969997b2ae7dbc/${SRCNAME}-${PV}.tar.gz \
           file://remove-pg-config.patch \
          "

SRC_URI[md5sum] = "4a392949ba31a378a18ed3e775a4693f"
SRC_URI[sha256sum] = "70490e12ed9c5c818ecd85d185d363335cc8a8cbf7212e3c185431c79ff8c05c"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

DEPENDS += " \
    postgresql \
"
