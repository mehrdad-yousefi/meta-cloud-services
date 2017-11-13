DESCRIPTION = "OpenStack Command-line Client"
HOMEPAGE = "https://github.com/openstack/python-openstackclient"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

PYPI_PACKAGE = "python-openstackclient"

SRC_URI[md5sum] = "c965b343b0fdf97d01e28d5460c7c175"
SRC_URI[sha256sum] = "875b54ac95e29cc83ae76513b48306c8493c12d5ba7d23aea3432216f2fa91ba"

inherit setuptools pypi

DEPENDS += "\
    python-pbr \
    "

RDEPENDS_${PN} += "\
    python-pbr \
    python-os-client-config \
    python-appdirs \
    python-keystoneauth1 \
    "
