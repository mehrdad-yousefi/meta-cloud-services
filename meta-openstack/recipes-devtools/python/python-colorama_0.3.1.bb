#
# Copyright (C) 2014 Wind River Systems, Inc.
#
DESCRIPTION = "Simple cross-platform colored terminal text in Python"
HOMEPAGE = "http://pypi.python.org/pypi/colorama"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=14d0b64047ed8f510b51ce0495995358"

PR = "r0"
SRCNAME = "colorama"

SRC_URI = "http://pypi.python.org/packages/source/c/${SRCNAME}/${SRCNAME}-${PV}.tar.gz \
          "

SRC_URI[md5sum] = "95ce8bf32f5c25adea14b809db3509cb"
SRC_URI[sha256sum] = "012261ba542a5b18076cac0eaa3892ebe6098e170591e08a8fc0fbf8ab3d5c90"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

DEPENDS += " \
        python-pip \
        "

