DESCRIPTION = "A generic, spec-compliant, thorough implementation of the OAuth request-signing logic"
HOMEPAGE = "https://github.com/idan/oauthlib"
SECTION = "devel/python"
LICENSE = "Apache-2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5ba9ce41463615e082609806255bce1b"

PR = "r1"

SRCNAME = "oauthlib"
SRC_URI = "http://pypi.python.org/packages/source/o/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "3ecba28f991ee58db2aeda8b4e2b56b1"
SRC_URI[sha256sum] = "0a11ab2311f7a29d0079fe529bde9503fec9a2bdd52db834cf8a284a8c1c52f9"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

# DEPENDS_default: python-pip

DEPENDS += " \
        python-pip \
        "

# RDEPENDS_default: 
RDEPENDS_${PN} += " \
        "

do_install_append() {
        perm_files=`find "${D}${PYTHON_SITEPACKAGES_DIR}/" -name "top_level.txt"`
        for f in $perm_files; do
                chmod 644 "${f}"
        done
}

