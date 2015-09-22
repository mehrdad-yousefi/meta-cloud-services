DESCRIPTION = "OpenStack test framework and test fixtures. \
The oslotest package can be cross-tested against its consuming projects to ensure \
that no changes to the library break the tests in those other projects."
HOMEPAGE = "https://pypi.python.org/pypi/oslotest"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

SRCNAME = "oslotest"

SRC_URI = "https://pypi.python.org/packages/source/o/${SRCNAME}/${SRCNAME}-${PV}.tar.gz \
"

SRC_URI[md5sum] = "54ba62e2e13619616ddce772fb267106"
SRC_URI[sha256sum] = "cb65b53b753375b669dcdb4717c362a205d19e3d16ca26310c0916cfd359354c"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

DEPENDS += "\
    python-pbr \
    "

RDEPENDS_${PN} = "python-fixtures \
                  python-subunit \
                  python-testrepository \
                  python-testscenarios \
                  python-testtools \
                  python-mock \
                  python-mox \
                  python-pbr \
                  bash \
"
