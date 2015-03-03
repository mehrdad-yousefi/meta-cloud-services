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

SRC_URI[md5sum] = "753b82f3bf632fbfc595816a0f6691f0"
SRC_URI[sha256sum] = "bff5e3320fae20e3e7650bed216847ec32f3e85329014edb4d7ec2bc1b68cae2"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

DEPENDS += " \
        python-pip \
        "

