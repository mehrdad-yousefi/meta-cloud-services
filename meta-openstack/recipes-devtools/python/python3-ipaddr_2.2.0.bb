DESCRIPTION = "Google's IP address manipulation library"
HOMEPAGE = "http://code.google.com/p/ipaddr-py/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=e7e54827196088e6e96b33e9aec35c4a"

SRC_URI[md5sum] = "f88353e40dec06410acfa075b8209b27"
SRC_URI[sha256sum] = "4092dfe667588d16aa12b59acb7c8a4024e5dcb23a681cd0b0b602373eca88d6"

inherit distutils3 pypi

DEPENDS += " \
        python3-pip \
        python3-pbr \
        "

RDEPENDS:${PN} += " \
        python3-pbr \
        "
