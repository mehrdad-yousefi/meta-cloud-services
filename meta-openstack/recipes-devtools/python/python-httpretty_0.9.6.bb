#
# Copyright (C) 2014 Wind River Systems, Inc.
#
DESCRIPTION = "HTTP client mock for Python"
HOMEPAGE = "https://pypi.python.org/pypi/httpretty"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=113a91608a1d89039af9393c39bcaa2c"

SRC_URI[md5sum] = "3b881b519e0f405caaf8aaa63f3508c0"
SRC_URI[sha256sum] = "01b52d45077e702eda491f4fe75328d3468fd886aed5dcc530003e7b2b5939dc"

inherit setuptools pypi

DEPENDS += " \
        python-pip \
        "

