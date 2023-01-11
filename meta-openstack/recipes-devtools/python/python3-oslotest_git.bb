DESCRIPTION = "OpenStack test framework and test fixtures. \
The oslotest package can be cross-tested against its consuming projects to ensure \
that no changes to the library break the tests in those other projects."
HOMEPAGE = "https://pypi.python.org/pypi/oslotest"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

PV = "4.5.0+git${SRCPV}"
SRCREV = "d4b189682ca2239abb23ab7b8ce33a5dbd9ffc42"

SRCNAME = "oslotest"
SRC_URI = "git://github.com/openstack/${SRCNAME}.git;branch=master;protocol=https"

S = "${WORKDIR}/git"

inherit setuptools3

DEPENDS += "\
    python3-pbr \
    "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python3-pbr-native \
	"

RDEPENDS:${PN} = "python3-fixtures \
                  python3-subunit \
                  python3-six \
                  python3-testrepository \
                  python3-testtools \
                  python3-mock \
                  python3-mox3 \
                  python3-os-client-config \
                  python3-debtcollector \
                  bash \
"
	
