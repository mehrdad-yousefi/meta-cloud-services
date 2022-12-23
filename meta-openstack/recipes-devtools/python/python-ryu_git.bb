DESCRIPTION = "Ryu component-based software defined networking framework"
HOMEPAGE = "http://osrg.github.io/ryu/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

PV = "4.19+git${SRCPV}"
SRCREV = "51a1130f6cdcb029a51b6a75d43ac5e4cdde7072"

SRCNAME = "ryu"
SRC_URI = "git://github.com/osrg/${SRCNAME}.git;branch=master;protocol=https"

S = "${WORKDIR}/git"

inherit setuptools3

FILES:${PN} += "${datadir}/etc/${SRCNAME}/*"

DEPENDS += " \
        python3-pip \
        python3-pbr \
        "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python3-pbr-native \
	"

RDEPENDS:${PN} += " \
        python3-eventlet \
        python-msgpack \
        python3-netaddr \
        python-oslo.config \
        python-ovs \
        python3-routes \
        python3-six \
        python-tinyrpc \
        python3-webob \
        "
