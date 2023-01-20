DESCRIPTION = "WSGI object-dispatching web framework"
HOMEPAGE = "https://pypi.python.org/pypi/pecan/"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d846877d24bbb3d7a00a985c90378e8c"

SRC_URI += " \
           file://avoids-duplicate-naming.patch \
          "

SRC_URI[md5sum] = "5ded3398853c3f5bc9c6838ca7d32761"
SRC_URI[sha256sum] = "49b255e701c3f1461605f5b0e8f54f0c21922d7845d414c24dd6409fe695d550"

inherit setuptools3 pypi

RDEPENDS:${PN} = "${PYTHON_PN}-mako \
                  ${PYTHON_PN}-webtest \
                  ${PYTHON_PN}-six \
                  ${PYTHON_PN}-logutils \
                  ${PYTHON_PN}-numbers \
                  ${PYTHON_PN}-backlash \
                  ${PYTHON_PN}-pprint \
"
