DESCRIPTION = "testscenarios: a pyunit extension for dependency injection"
HOMEPAGE = "https://pypi.python.org/pypi/testscenarios"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://BSD;md5=0805e4f024d089a52dca0671a65b8b66"

PR = "r0"

SRCNAME = "testscenarios"
SRC_URI = "https://pypi.python.org/packages/source/t/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "859073d9e7b049aee2e6704c51f6001a"
SRC_URI[sha256sum] = "c257cb6b90ea7e6f8fef3158121d430543412c9a87df30b5dde6ec8b9b57a2b6"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

DEPENDS += "\
    python-pbr \
    "

RDEPENDS_${PN} += "\
    python-testtools \
    python-pbr \
    "
