DESCRIPTION = "WSGI object-dispatching web framework"
HOMEPAGE = "https://pypi.python.org/pypi/pecan/"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d846877d24bbb3d7a00a985c90378e8c"

SRC_URI[md5sum] = "42bff04c3a90c32d78560fe7921658d4"
SRC_URI[sha256sum] = "24f06cf88a488b75f433e62b33c1c97e4575d0cd91eec9eec841a81cecfd6de3"

inherit setuptools pypi

RDEPENDS_${PN} = "python-mako \
                  python-webtest \
                  python-six \
                  python-logutils \
"
