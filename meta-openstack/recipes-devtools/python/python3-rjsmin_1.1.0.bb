DESCRIPTION = "rJSmin is a javascript minifier written in python."
HOMEPAGE = "http://opensource.perlig.de/rjsmin/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI[md5sum] = "ff73482370832bcc8e75571c35b7a79b"
SRC_URI[sha256sum] = "b15dc75c71f65d9493a8c7fa233fdcec823e3f1b88ad84a843ffef49b338ac32"

inherit setuptools3 pypi

RDEPENDS:${PN} += " \
        "

CLEANBROKEN = "1"
