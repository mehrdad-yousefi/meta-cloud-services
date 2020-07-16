DESCRIPTION = "Amazon Web Services API"
HOMEPAGE = "https://github.com/boto/boto"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=a1067d091272fcce8cc3d88d7e6fdc01"

SRC_URI[md5sum] = "e9b79f80198da059d9a8055a5352fd6d"
SRC_URI[sha256sum] = "ea0d3b40a2d852767be77ca343b58a9e3a4b00d9db440efb8da74b4e58025e5a"

RDEPENDS_${PN} += "\
	python3-json \
	python3-netclient \
	python3-threading \
	python3-xml \
	python3-logging \
	python3-pickle \
	python3-netserver \
"

inherit setuptools3 pypi

