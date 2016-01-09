DESCRIPTION = "An implementation of time.monotonic()"
HOMEPAGE = "https://github.com/atdt/monotonic"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d2794c0df5b907fdace235a619d80314"

PV = "0.4"
SRCREV = "93b3d3ba63597e57b20333db4e33ca0f48debf2a"

SRCNAME = "monotonic"
SRC_URI = "git://github.com/atdt/${SRCNAME}.git"

S = "${WORKDIR}/git"

inherit distutils

DEPENDS += " \
        python-pbr \
        "

RDEPENDS_${PN} += " \
        python-pbr \
        "

do_install_append() {
    # Using these "longest" paths will ensure needed shorter paths will be created
    install -d ${D}/${libdir}/python2.7/site-packages/${SRCNAME}.egg-info

    install -m 644 ${S}/${SRCNAME}.py ${D}/${libdir}/python2.7/site-packages/
    install -m 644 ${S}/${SRCNAME}.egg-info/* ${D}/${libdir}/python2.7/site-packages/${SRCNAME}.egg-info/
}
