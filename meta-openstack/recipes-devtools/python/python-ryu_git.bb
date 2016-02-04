DESCRIPTION = "Ryu component-based software defined networking framework"
HOMEPAGE = "http://osrg.github.io/ryu/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

PV = "3.27+git${SRCPV}"
SRCREV = "0aefad7048079656cdaad138be58f017e6b4f1ce"

SRCNAME = "ryu"
SRC_URI = "git://github.com/osrg/${SRCNAME}.git"

S = "${WORKDIR}/git"

inherit setuptools

FILES_${PN} += "${datadir}/etc/${SRCNAME}/*"

DEPENDS += " \
        python-pip \
        python-pbr \
        "

RDEPENDS_${PN} += " \
        python-eventlet \
        python-msgpack \
        python-netaddr \
        python-oslo.config \
        python-routes \
        python-six \
        python-webob \
        "
