DESCRIPTION = "Backports and enhancements for the contextlib module"
HOMEPAGE = "http://contextlib2.readthedocs.org/"
SECTION = "devel/python"
LICENSE = "PSF"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=43d1c7827e8fad6454b553caf0e1d734"

SRC_URI[md5sum] = "ea687207db25f65552061db4a2c6727d"
SRC_URI[sha256sum] = "55a5dc78f7a742a0e756645134ffb39bbe11da0fea2bc0f7070d40dac208b732"

inherit setuptools pypi

DEPENDS += " \
        python-pip \
        "

RDEPENDS_${PN} += " \
        "

