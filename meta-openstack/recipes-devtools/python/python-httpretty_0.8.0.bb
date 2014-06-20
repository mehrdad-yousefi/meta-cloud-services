#
# Copyright (C) 2014 Wind River Systems, Inc.
#
DESCRIPTION = "HTTP client mock for Python"
HOMEPAGE = "https://pypi.python.org/pypi/httpretty"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=fac859f0c7aee8d7f10b1aa5b130d1a7"

PR = "r0"
SRCNAME = "httpretty"

SRC_URI = "https://pypi.python.org/packages/source/h/${SRCNAME}/${SRCNAME}-${PV}.tar.gz \
          "

SRC_URI[md5sum] = "2d5ea5205c358fa489e6de6fc74c00fa"
SRC_URI[sha256sum] = "e5512b38ad3bfb9f7d275c957b4a7eddc69e4b3a749e3b62a984c86fb6ab329b"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

DEPENDS += " \
        python-pip \
        "

