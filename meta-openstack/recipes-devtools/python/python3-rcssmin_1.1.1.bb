DESCRIPTION = "RCSSmin is a CSS minifier."
HOMEPAGE = "http://opensource.perlig.de/rcssmin/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI[md5sum] = "c5528702ab9d2d6189fb955c7da73196"
SRC_URI[sha256sum] = "4f9400b4366d29f5f5446f58e78549afa8338e6a59740c73115e9f6ac413dc64"

inherit setuptools3 pypi

RDEPENDS:${PN} += " \
        "

CLEANBROKEN = "1"
