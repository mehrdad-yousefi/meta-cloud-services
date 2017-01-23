#
# Copyright (C) 2014 Wind River Systems, Inc.
#
DESCRIPTION = "HTTP client mock for Python"
HOMEPAGE = "https://pypi.python.org/pypi/httpretty"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=88d874c445b42d9bcea5d211bbc6b8bd"

PR = "r0"
SRCNAME = "httpretty"

SRC_URI = "https://pypi.python.org/packages/7c/7d/fdc08c3ecc0d49cb95cb67fd03034915e0f8d714b18f4d739c062a10a95c/${SRCNAME}-${PV}.tar.gz \
          "

SRC_URI[md5sum] = "2a6bbf270fafc77647b0479d95d0544c"
SRC_URI[sha256sum] = "83c176bbac9d68a45a5cca54f2d5be7e6b16a063adf6f334e7fd0eee272e976e"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

DEPENDS += " \
        python-pip \
        "

