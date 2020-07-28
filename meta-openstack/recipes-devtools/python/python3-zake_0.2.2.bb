DESCRIPTION = "A python package that works to provide a nice set of testing utilities for the kazoo library."
HOMEPAGE = "https://github.com/yahoo/Zake"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=14e79e6983dbd678bbe0ff17229d8fc1"

SRC_URI[md5sum] = "076dcb58f5cb8b50f575fc0ca7e810b9"
SRC_URI[sha256sum] = "5a50859931c4f666d318b74d1c407a6150dd5194e4c5812d071a5c7c7cefe4e6"

inherit setuptools3 pypi

DEPENDS += " \
        python3-pip \
        "

RDEPENDS_${PN} += " \
        python3-kazoo \
        "
