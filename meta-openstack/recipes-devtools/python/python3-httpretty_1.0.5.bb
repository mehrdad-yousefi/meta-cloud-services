#
# Copyright (C) 2014 Wind River Systems, Inc.
#
DESCRIPTION = "HTTP client mock for Python"
HOMEPAGE = "https://pypi.python.org/pypi/httpretty"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=d87f7868a62b8d598eab40164594d21b"

SRC_URI[md5sum] = "6d71a2387997ae8523dcc7ada51cb46a"
SRC_URI[sha256sum] = "e53c927c4d3d781a0761727f1edfad64abef94e828718e12b672a678a8b3e0b5"

inherit setuptools3 pypi

DEPENDS += " \
        ${PYTHON_PN}-pip \
        "

RDEPENDS:${PN} = " \
	${PYTHON_PN}-crypt \
	${PYTHON_PN}-logging \
	${PYTHON_PN}-json \
	${PYTHON_PN}-core \
"
