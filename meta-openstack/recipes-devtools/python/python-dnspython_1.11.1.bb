DESCRIPTION = "DNS toolkit for Python"
HOMEPAGE = "http://www.dnspython.org/"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=397eddfcb4bc7e2ece2fc79724a7cca2"

PR = "r0"
SRCNAME = "dnspython"
SRC_URI = "http://www.dnspython.org/kits/${PV}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "6167344ca849bd2ba108a8aa6118cb2b"
SRC_URI[sha256sum] = "c0c6fcf3ff52939e7eadd931282d083271f65cf0a174555a703563a400289768"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

# avoid "error: option --single-version-externally-managed not recognized"
DISTUTILS_INSTALL_ARGS = "--root=${D} \
    --prefix=${prefix} \
    --install-lib=${PYTHON_SITEPACKAGES_DIR} \
    --install-data=${datadir}"
