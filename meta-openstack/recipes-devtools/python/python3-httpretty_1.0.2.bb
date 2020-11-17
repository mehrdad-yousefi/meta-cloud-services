#
# Copyright (C) 2014 Wind River Systems, Inc.
#
DESCRIPTION = "HTTP client mock for Python"
HOMEPAGE = "https://pypi.python.org/pypi/httpretty"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=d87f7868a62b8d598eab40164594d21b"

SRC_URI[md5sum] = "1f6b9b64818837134b93839e5c7051bb"
SRC_URI[sha256sum] = "24a6fd2fe1c76e94801b74db8f52c0fb42718dc4a199a861b305b1a492b9d868"

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
