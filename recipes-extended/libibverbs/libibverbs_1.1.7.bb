SUMMARY = "Support InfiniBand verbs"
DESCRIPTION = "Libibverbs is a library that allows userspace processes to use InfiniBand/RDMA 'verbs' directly."
HOMEPAGE = "http://www.openfabrics.org/downloads/verbs/"
SECTION = "libs/devel"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=7c557f27dd795ba77cc419dddc656b51"

# Official repo is at git://git.kernel.org/pub/scm/libs/infiniband/libibverbs.git
SRC_URI = "https://www.openfabrics.org/downloads/verbs/${BPN}-${PV}.tar.gz"

SRC_URI[md5sum] = "5aea59e4766ae4548419010ac84032ff"
SRC_URI[sha256sum] = "31b4114bf32d41c9fc81a862ec5febed1e982975f21fa177ea9c7516c9064690"

inherit autotools

PACKAGES += "${PN}-utils"
FILES_${PN} = "${sysconfdir} ${libdir}/*.so.*"
FILES_${PN}-utils = "${bindir}"

PACKAGECONFIG ??= ""
PACKAGECONFIG[valgrind] = "--with-valgrind,--without-valgrind,valgrind,"

do_install_append() {
        mkdir -p ${D}${sysconfdir}/libibverbs.d
        rm -f ${D}${libdir}/libibverbs.la
}

PROVIDES = "virtual/libibverbs"
RPROVIDES_${PN} = "virtual/libibverbs"
