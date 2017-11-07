DESCRIPTION = "A simple statsd client."
HOMEPAGE = "https://github.com/jsocol/pystatsd"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4d8aa8ac1dc54b8aee4054bd5e5c61bd"

inherit pypi

SRC_URI[md5sum] = "d819e2375030f543522012046e6e36e9"
SRC_URI[sha256sum] = "3fa92bf0192af926f7a0d9be031fe3fd0fbaa1992d42cf2f07e68f76ac18288e"

inherit setuptools

RDEPENDS_${PN} += " \
        "
