DESCRIPTION = "An unladen web framework for building APIs and app backends."
HOMEPAGE = "http://projects.unbit.it/uwsgi/"
SECTION = "net"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=33ab1ce13e2312dddfad07f97f66321f"

SRCNAME = "uwsgi"
SRC_URI = "git://github.com/unbit/uwsgi.git;branch=master;protocol=https \
    file://Add-explicit-breaks-to-avoid-implicit-passthrough.patch \
"

SRCREV="0d1c793465ac331bdb43c6d56fb7c348ea94f463"
PV="2.0.21+git${SRCPV}"
S = "${WORKDIR}/git"

inherit setuptools3 pkgconfig

# prevent host contamination and remove local search paths
export UWSGI_REMOVE_INCLUDES = "/usr/include,/usr/local/include"

DEPENDS += " \
        e2fsprogs \
        python3-pip \
        python3-six \
        yajl \
        "

# RDEPENDS:default: 
RDEPENDS:${PN} += " \
        "

CLEANBROKEN = "1"

