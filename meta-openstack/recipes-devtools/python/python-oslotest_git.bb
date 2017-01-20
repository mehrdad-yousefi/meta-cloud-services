DESCRIPTION = "OpenStack test framework and test fixtures. \
The oslotest package can be cross-tested against its consuming projects to ensure \
that no changes to the library break the tests in those other projects."
HOMEPAGE = "https://pypi.python.org/pypi/oslotest"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

PV = "2.10.0+git${SRCPV}"
SRCREV = "a8c5ed4008963a3436f4a4932ac544f5ee4c283b"

SRCNAME = "oslotest"
SRC_URI = "git://github.com/openstack/${SRCNAME}.git;branch=stable/newton"

S = "${WORKDIR}/git"

inherit setuptools

DEPENDS += "\
    python-pbr \
    "

RDEPENDS_${PN} = "python-fixtures \
                  python-subunit \
                  python-six \
                  python-testrepository \
                  python-testscenarios \
                  python-testtools \
                  python-mock \
                  python-mox3 \
                  python-os-client-config \
                  python-debtcollector \
                  python-pbr \
                  bash \
"
