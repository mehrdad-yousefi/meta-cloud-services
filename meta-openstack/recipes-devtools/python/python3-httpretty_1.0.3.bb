#
# Copyright (C) 2014 Wind River Systems, Inc.
#
DESCRIPTION = "HTTP client mock for Python"
HOMEPAGE = "https://pypi.python.org/pypi/httpretty"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=d87f7868a62b8d598eab40164594d21b"

SRC_URI[md5sum] = "f42d7dcee7efa3b4aa842494abb23cac"
SRC_URI[sha256sum] = "9335cbd8f38745e0e2dc4755d8932a77d378d93e15804969504b1e6b568d613c"

inherit setuptools3 pypi

DEPENDS += " \
        ${PYTHON_PN}-pip \
        "

RDEPENDS_${PN} = " \
	${PYTHON_PN}-crypt \
	${PYTHON_PN}-logging \
	${PYTHON_PN}-json \
	${PYTHON_PN}-core \
"
