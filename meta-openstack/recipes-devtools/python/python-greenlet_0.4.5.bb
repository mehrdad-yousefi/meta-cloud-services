SUMMARY = "Python lightweight in-process concurrent programming"
HOMEPAGE = "http://pypi.python.org/pypi/greenlet"
SECTION = "devel/python"
LICENSE = "MIT & PSF"
LIC_FILES_CHKSUM = "file://LICENSE;md5=03143d7a1a9f5d8a0fee825f24ca9c36 \
                    file://LICENSE.PSF;md5=c106931d9429eda0492617f037b8f69a"

# Archived version so we have to overwrite what the pypi class will derive
PYPI_SRC_URI = "https://pypi.python.org/packages/source/g/greenlet/greenlet-${PV}.zip"

SRC_URI[md5sum] = "ce383f6475e6311cf8932ea779938703"
SRC_URI[sha256sum] = "b990f00f120c4cfb6672eec2acd32210990a2c7b70b815c034d1d8cbf08e2dbe"

inherit distutils pypi

