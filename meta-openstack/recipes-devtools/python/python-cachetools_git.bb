DESCRIPTION = "Extensible memoizing collections and decorators"
HOMEPAGE = "https://github.com/tkem/cachetools"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=96c958336b659af4dad628356c5e43b6"

SRCNAME = "cachetools"

PV = "1.1.5+git${SRCPV}"
SRCREV = "42853733d0caf68ef5bf5933a377572b05437e2c"

SRC_URI = "git://github.com/tkem/${SRCNAME}.git"

S = "${WORKDIR}/git"

inherit setuptools
