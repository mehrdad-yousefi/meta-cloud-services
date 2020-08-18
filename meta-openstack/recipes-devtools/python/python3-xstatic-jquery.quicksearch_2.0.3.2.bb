DESCRIPTION = "JQuery.quicksearch JavaScript library packaged for setuptools3 "
HOMEPAGE = "https://pypi.python.org/pypi/XStatic-JQuery.quicksearch"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=060aa7a2790c1c3eebeae9236bf16799"

PYPI_PACKAGE = "XStatic-JQuery.quicksearch"

SRC_URI[md5sum] = "ac6148cfff5a7a90240e7801bf9f0e4a"
SRC_URI[sha256sum] = "f38760fe93b504f2855ef25e9bf91df65c8a6601674165e4685fb217bb616fd1"

inherit setuptools3 pypi

# DEPENDS_default: python3-pip

DEPENDS += " \
        python3-pip \
        "

# RDEPENDS_default: 
RDEPENDS_${PN} += " \
        "
