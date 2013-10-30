DESCRIPTION = "Python Build Reasonableness: PBR is a library that injects some useful and sensible default behaviors into your setuptools run"
HOMEPAGE = "https://pypi.python.org/pypi/pbr"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

PR = "r0"
SRCNAME = "pbr"

SRC_URI = "https://pypi.python.org/packages/source/p/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "3bb4f92e970dab5807d3f8189d6cfa10"
SRC_URI[sha256sum] = "656c8ce897d4489269e1303b47f2b154ec7e344699c79ea6573e1fd0b0fbc3e6"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools


