DESCRIPTION = "Client library for OpenStack Identity API"
HOMEPAGE = "https://github.com/openstack/python-keystoneclient"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4a4d0e932ffae1c0131528d30d419c55"

PR = "r0"

SRC_URI = "http://pypi.python.org/packages/source/p/${PN}/${PN}-${PV}.tar.gz"

SRC_URI[md5sum] = "ad6fcbdd0e4cb239d315155bdbe9337c"
SRC_URI[sha256sum] = "10b98946aaa98e97f032ca44848a5d84bc61d6f0b4186c635704087e72c08818"

inherit setuptools

FILES_${PN}-doc += "${datadir}/keystoneclient" 

RDEPENDS_${PN} += "python-iso8601 \
	python-prettytable \
	python-requests \
	python-simplejson \
	python-oslo.config \
	"
