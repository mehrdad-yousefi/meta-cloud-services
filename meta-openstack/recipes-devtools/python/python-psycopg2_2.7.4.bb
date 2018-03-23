DESCRIPTION = "Python-PostgreSQL Database Adapter"
HOMEPAGE = "http://initd.org/psycopg/"
SECTION = "devel/python"
LICENSE = "GPLv3+"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2c9872d13fa571e7ba6de95055da1fe2"
DEPENDS = "postgresql"

SRC_URI += " \
           file://remove-pg-config.patch \
          "

SRC_URI[md5sum] = "70fc57072e084565a42689d416cf2c5c"
SRC_URI[sha256sum] = "8bf51191d60f6987482ef0cfe8511bbf4877a5aa7f313d7b488b53189cf26209"

inherit distutils pypi

DEPENDS += " \
    postgresql \
"
