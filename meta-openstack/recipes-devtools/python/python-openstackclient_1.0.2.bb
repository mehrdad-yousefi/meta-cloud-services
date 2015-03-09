DESCRIPTION = "OpenStack Command-line Client"
HOMEPAGE = "https://github.com/openstack/python-openstackclient"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

PR = "r0"
SRCNAME = "python-openstackclient"

SRC_URI = "http://pypi.python.org/packages/source/p/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "44f33ac00cd47392688af959178eb5c3"
SRC_URI[sha256sum] = "6d1d5c8100f37b96b7d6f9a8b429af790235cb33b54c6237c16b0b1534c851b7"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
