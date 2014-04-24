DESCRIPTION = "An unladen web framework for building APIs and app backends."
HOMEPAGE = "http://falconframework.org"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://README.rst;md5=795813ca586f7662f91b9ff2265f4bc5"

PR = "r0"

SRCNAME = "falcon"
SRC_URI = "http://pypi.python.org/packages/source/f/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "82049bd4a6a3e2ec4bb7ea59955a2493"
SRC_URI[sha256sum] = "dafccf547df57324993c8c13a0e40629b61817e0462f04c7e44fed12f26ff556"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

# conflicting file prevention
do_install_append() {
	rm -f ${D}${libdir}/python*/site-packages/tests/*
}

DEPENDS += " \
        python-pip \
        "

RDEPENDS_${PN} += " \
        python-six \
        python-mimeparse \
        "
