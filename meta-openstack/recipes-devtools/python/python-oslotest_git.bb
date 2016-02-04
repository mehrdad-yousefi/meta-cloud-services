DESCRIPTION = "OpenStack test framework and test fixtures. \
The oslotest package can be cross-tested against its consuming projects to ensure \
that no changes to the library break the tests in those other projects."
HOMEPAGE = "https://pypi.python.org/pypi/oslotest"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

PV = "1.12.0+git${SRCPV}"
SRCREV = "b5e355fcecdf7727fe33e355c4f87d1971b5fef5"

SRCNAME = "oslotest"
SRC_URI = "git://github.com/openstack/${SRCNAME}.git"

S = "${WORKDIR}/git"

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
