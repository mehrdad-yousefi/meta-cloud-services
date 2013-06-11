DESCRIPTION = "Config file parser module"
HOMEPAGE = "http://search.cpan.org/dist/Config-General/"
LICENSE = "Artistic-1.0 | GPL-1.0+"
SECTION = "libs"
PR = "r0"
LIC_FILES_CHKSUM = "file://README;beginline=90;endline=90;md5=3ba4bbac1e79a08332688196f637d2b2"

SRCNAME = "Config-General"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/T/TL/TLINDEN/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "3100325f99bdc2f265645a842e6bb025"
SRC_URI[sha256sum] = "8ff530cd4818a040c1bc2ba96e3e8237241dde1208d206685d1204270ef00bce"

S = "${WORKDIR}/${SRCNAME}-${PV}"

EXTRA_CPANFLAGS = "EXPATLIBPATH=${STAGING_LIBDIR} EXPATINCPATH=${STAGING_INCDIR}"

inherit cpan

do_compile() {
    export LIBC="$(find ${STAGING_DIR_TARGET}/${base_libdir}/ -name 'libc-*.so')"
    cpan_do_compile
}
