DESCRIPTION = "WebSockets support for any application/server"
HOMEPAGE = "https://github.com/kanaka/websockify"
SECTION = "devel/python"
LICENSE = "LGPLv3"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=eb81922f483833198eace60f1469f99d"

SRC_URI[md5sum] = "ff745fd67457fd077915753c9b808b2a"
SRC_URI[sha256sum] = "c35b5b79ebc517d3b784dacfb993be413a93cda5222c6f382443ce29c1a6cada"

inherit setuptools3 pypi

RDEPENDS:${PN} += "gmp"

FILES:${PN} += "${datadir}/*"
