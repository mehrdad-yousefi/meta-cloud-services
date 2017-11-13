DESCRIPTION = "Import exceptions from potentially bundled packages in requests."
HOMEPAGE = "https://www.openstack.org/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d273d63619c9aeaf15cdaf76422c4f87"

SRC_URI[md5sum] = "85c9a2c5c5ecbd2deb0a491613fbdd12"
SRC_URI[sha256sum] = "8f141ba636d6748cd29208c1955bde38bf00fcdda1a685bc09d8ed133700353e"

inherit setuptools pypi

# conflicting file prevention
do_install_append() {
	rm -f ${D}${libdir}/python*/site-packages/tests/*
}

DEPENDS += " \
        python-pbr-native \
        "

RDEPENDS_${PN} += " \
        python-pbr \
        "
