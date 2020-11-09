DESCRIPTION = "backlash is a swiss army knife for web applications debugging"
HOMEPAGE = "https://pypi.org/project/backlash/"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ca5c23eefc8077a81d9c7b5384f38be8"

SRC_URI[md5sum] = "c80c065e33b6891c5e5ac70ac3a2551c"
SRC_URI[sha256sum] = "ddf6e1d59ce30deb190478c98ade84557ee9333435fbd377c011588c71f862a0"

inherit setuptools3 pypi

RDEPENDS_${PN} += " \
	python3-netclient \
	python3-netserver \
	python3-json \
	python3-webob \
	python3-threading \
	python3-logging \
"
