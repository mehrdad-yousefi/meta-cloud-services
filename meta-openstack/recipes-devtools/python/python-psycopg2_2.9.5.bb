DESCRIPTION = "Python-PostgreSQL Database Adapter"
HOMEPAGE = "http://initd.org/psycopg/"
SECTION = "devel/python"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=89ae5da7594f6112905b3a7b0c76ff7f"
DEPENDS = "postgresql"

SRC_URI += " \
           file://remove-pg-config.patch \
          "

SRC_URI[md5sum] = "3cec7285f61690633bb070d4bba259c2"
SRC_URI[sha256sum] = "a5246d2e683a972e2187a8714b5c2cf8156c064629f9a9b1a873c1730d9e245a"

inherit setuptools3 pypi

DEPENDS += " \
    postgresql \
"
