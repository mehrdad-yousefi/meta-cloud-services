DESCRIPTION = "pyScss, a Scss compiler for Python"
HOMEPAGE = "http://github.com/Kronuz/pyScss"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=28155276e8df3f75bbd327335f66f2fa"

PYPI_PACKAGE = "pyScss"

SRC_URI[md5sum] = "c75fa4ea88d3c9df57a11679f337a939"
SRC_URI[sha256sum] = "f1df571569021a23941a538eb154405dde80bed35dc1ea7c5f3e18e0144746bf"

inherit setuptools3 pypi

# DEPENDS_default: python3-pip

DEPENDS += " \
        python3-pip \
        libpcre \
        python3-six \
        "

# RDEPENDS:default: 
RDEPENDS:${PN} += " \
	python3-logging \
	python3-six \
	python3-numbers \
	python3-image \
        "

CLEANBROKEN = "1"

