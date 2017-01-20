DESCRIPTION = "Import exceptions from potentially bundled packages in requests."
HOMEPAGE = "https://www.openstack.org/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d273d63619c9aeaf15cdaf76422c4f87"

PR = "r0"

SRCNAME = "requestsexceptions"
SRC_URI = "http://pypi.io/packages/source/r/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "edf208c247261157bf7a97d7c792d914"
SRC_URI[sha256sum] = "d678b872f51f76d875e00e6667f4ddbf013b3a99490ae5fe07cf3e4f846e283e"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

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
