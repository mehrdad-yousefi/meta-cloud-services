DESCRIPTION = "Cryptographic modules for Python."
HOMEPAGE = "http://www.pycrypto.org/"
SECTION = "devel/python"
LICENSE = "PSFv2"
LIC_FILES_CHKSUM = "file://COPYRIGHT;md5=35f354d199e8cb7667b059a23578e63d"

PR = "r0"
SRCNAME = "pycrypto"

SRC_URI = "https://pypi.python.org/packages/source/p/${SRCNAME}/${SRCNAME}-${PV}.tar.gz \
           file://cross-compiling.patch"

SRC_URI[md5sum] = "88dad0a270d1fe83a39e0467a66a22bb"
SRC_URI[sha256sum] = "7293c9d7e8af2e44a82f86eb9c3b058880f4bcc884bf3ad6c8a34b64986edde8"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

export STAGING_INCDIR
export STAGING_LIBDIR
export BUILD_SYS
export HOST_SYS

CONFIGUREOPTS = "--build=${BUILD_SYS} \
                 --host=${HOST_SYS} \
                 --target=${TARGET_SYS} \
                 --prefix=${prefix} \
                 --exec_prefix=${exec_prefix} \
                 --bindir=${bindir} \
                 --sbindir=${sbindir} \
                 --libexecdir=${libexecdir} \
                 --datadir=${datadir} \
                 --sysconfdir=${sysconfdir} \
                 --sharedstatedir=${sharedstatedir} \
                 --localstatedir=${localstatedir} \
                 --libdir=${libdir} \
                 --includedir=${includedir} \
                 --oldincludedir=${oldincludedir} \
                 --infodir=${infodir} \
                 --mandir=${mandir} \
                 --disable-silent-rules \
                 --with-libtool-sysroot=${STAGING_DIR_HOST}"

do_configure () {
    # Workaround autoconf bug
    export ac_cv_func_malloc_0_nonnull=yes

    ./configure ${CONFIGUREOPTS}
}

