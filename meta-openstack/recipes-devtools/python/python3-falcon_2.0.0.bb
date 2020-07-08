DESCRIPTION = "An unladen web framework for building APIs and app backends."
HOMEPAGE = "http://falconframework.org"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://README.rst;md5=a0c7260e38287caff6c266d1f287e962"

SRC_URI[md5sum] = "77c52c144dd284e6259d257c6f008072"
SRC_URI[sha256sum] = "eea593cf466b9c126ce667f6d30503624ef24459f118c75594a69353b6c3d5fc"

inherit setuptools3 pypi

# conflicting file prevention
do_install_append() {
	rm -f ${D}${libdir}/python*/site-packages/tests/*
}

DEPENDS += " \
        python3-pip \
        "

RDEPENDS_${PN} += " \
        python3-six \
        python3-json \
        python3-xml \
        python3-netserver \
        "
