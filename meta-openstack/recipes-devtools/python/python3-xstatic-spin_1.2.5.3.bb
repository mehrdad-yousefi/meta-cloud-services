DESCRIPTION = "Spin JavaScript library packaged for setuptools3"
HOMEPAGE = "https://pypi.python.org/pypi/XStatic-Spin"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=45c30e2aa7df682a626f8e3629b8f7ee"

PYPI_PACKAGE = "XStatic-Spin"

SRC_URI[md5sum] = "d0cad2593c74eec38dbeed5161eab462"
SRC_URI[sha256sum] = "06e889cf3318f08ce74ef888b45d9f1e09017bb8e6d519a299c10a9e6b542642"

inherit setuptools3 pypi

# DEPENDS_default: python3-pip

DEPENDS += " \
        python3-pip \
        "

# RDEPENDS:default: 
RDEPENDS:${PN} += " \
        "
