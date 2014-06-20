DESCRIPTION = "WSGI object-dispatching web framework"
HOMEPAGE = "https://pypi.python.org/pypi/pecan/"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d846877d24bbb3d7a00a985c90378e8c"

PR = "r0"
SRCNAME = "pecan"

SRC_URI = "https://pypi.python.org/packages/source/p/${SRCNAME}/${SRCNAME}-${PV}.tar.gz \
"

SRC_URI[md5sum] = "819ea890e8a0412717b8aa791595725f"
SRC_URI[sha256sum] = "726d000cc2b5078de560a9a69e29637c59fc93b6707b292a56bdb0a466555922"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

RDEPENDS_${PN} = "python-webob \
                  python-mako \
                  python-webtest \
                  python-six \
                  python-logutils \
"
