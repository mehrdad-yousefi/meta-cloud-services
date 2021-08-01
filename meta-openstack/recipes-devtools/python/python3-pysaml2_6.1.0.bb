DESCRIPTION = "Python implementation of SAML Version 2 to be used in a WSGI environment"
HOMEPAGE = "https://github.com/rohe/pysaml2"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=861cc9087857b5bea2e11356c3de95d9"

inherit setuptools3 pypi

SRC_URI[sha256sum] = "f7b80553f84bf4e3c823266d2243ab6c0303785648402fbbc1c13a14737876d4"

DEPENDS += " \
        python3-pip \
        "

RDEPENDS:${PN} += " \
	python3-zopeinterface \
	python3-repoze.who \
        "
