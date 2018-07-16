#
# Copyright (C) 2014 Wind River Systems, Inc.
#
DESCRIPTION = "HTTP client mock for Python"
HOMEPAGE = "https://pypi.python.org/pypi/httpretty"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=113a91608a1d89039af9393c39bcaa2c"

SRC_URI[md5sum] = "e0e4294987c02181b1141c9ceb81783f"
SRC_URI[sha256sum] = "543fa2bd9c319bfa1e1de9e37d7c9c08fa926a692b65b0be5df4b2f069fd0ad7"

inherit setuptools pypi

DEPENDS += " \
        python-pip \
        "

