DESCRIPTION = "WSGI object-dispatching web framework"
HOMEPAGE = "https://pypi.python.org/pypi/pecan/"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d846877d24bbb3d7a00a985c90378e8c"

PR = "r0"
SRCNAME = "pecan"

SRC_URI = "https://pypi.python.org/packages/source/p/${SRCNAME}/${SRCNAME}-${PV}.tar.gz \
"

SRC_URI[md5sum] = "e2b329c5088c2adb1510ac9d1af84bca"
SRC_URI[sha256sum] = "ca6c31e1fb98e4ae780a44a40a88eacb7a19172d3f64d4e31f32049a784a1281"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

RDEPENDS_${PN} = "python-webob \
                  python-mako \
                  python-webtest \
                  python-six \
                  python-logutils \
"
