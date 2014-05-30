#
# Copyright (C) 2014 Wind River Systems, Inc.
#
DESCRIPTION = "Django test runner using nose"
HOMEPAGE = "https://github.com/django-nose/django-nose"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7f88f52f66738ec7259424ce46e855c2"

PR = "r0"
SRCNAME = "django-nose"

SRC_URI = "http://pypi.python.org/packages/source/d/${SRCNAME}/${SRCNAME}-${PV}.tar.gz \ 
          "

SRC_URI[md5sum] = "199d5358317a804b39fe05d806cab427"
SRC_URI[sha256sum] = "9aae16b562866a4ddaa5e8978729abadbbed544728d88e0b9c9af7b31dd072ed"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

DEPENDS += " \
        python-pip \
        "

RDEPENDS_${PN} += " \
        python-django \
        python-nose \
        "

