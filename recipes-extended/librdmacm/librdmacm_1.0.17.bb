SUMMARY = "Userspace RDMA Connection Manager"
DESCRIPTION = "\
User space RDMA 'socket' protocol and libraries for establising RDMA\
communication.  Includes both Infiniband specific and general RDMA\
communication management libraries for unreliable datagram, reliable\
connected, and multicast data transfers.\
Also includes ACM (communication management assistant) service."

HOMEPAGE = "http://www.openfabrics.org/downloads/rdmacm/"
SECTION = "libs/devel"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=39cc3044d68741f9005da73e9b92db95"

DEPENDS = "virtual/libibverbs"

# Repo is at http://git.openfabrics.org/git?p=~shefty/librdmacm.git
SRC_URI = "https://www.openfabrics.org/downloads/rdmacm/${BPN}-${PV}.tar.gz \
           file://librdmacm-needs-libdl.patch"

SRC_URI[md5sum] = "da6fad887e9c24cb01b74b75f8449cb1"
SRC_URI[sha256sum] = "9381e1bf2c7079fc257b8eee74e731d3e7eec70e539bb4245084a7b05aeecb2a"

inherit autotools

# Allow plug-in symlinks.
INSANE_SKIP_${PN} += "dev-so"

PACKAGES += "${PN}-utils"
FILES_${PN} = "${libdir}/*.so.* ${libdir}/rsocket/*.so*"
FILES_${PN}-utils = "${bindir}"
FILES_${PN}-staticdev += "${libdir}/rsocket/librspreload.a"
FILES_${PN}-dbg += "${libdir}/rsocket/.debug"

PACKAGECONFIG ??= ""
PACKAGECONFIG[valgrind] = "--with-valgrind,--without-valgrind,valgrind,"

do_install_append() {
        rm -f ${D}${libdir}/librdmacm.la
        rm -f ${D}${libdir}/rsocket/librspreload.la
}
