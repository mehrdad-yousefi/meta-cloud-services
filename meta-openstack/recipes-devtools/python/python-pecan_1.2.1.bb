DESCRIPTION = "WSGI object-dispatching web framework"
HOMEPAGE = "https://pypi.python.org/pypi/pecan/"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d846877d24bbb3d7a00a985c90378e8c"

PR = "r0"
SRCNAME = "pecan"

SRC_URI = "https://pypi.python.org/packages/27/b2/eaa47baa88c848ea748e1583246c55466b3ba087cd413fc9a3cd51a6c5f5/${SRCNAME}-${PV}.tar.gz \
"

SRC_URI[md5sum] = "d0ad387dbc77d1803ad3573fe38a4e0a"
SRC_URI[sha256sum] = "8d95457b9cedcfda9b467f5cc7dde8cdf72ddba6b402d6a5902843d1b2186c46"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

RDEPENDS_${PN} = "python-webob \
                  python-mako \
                  python-webtest \
                  python-six \
                  python-logutils \
"
