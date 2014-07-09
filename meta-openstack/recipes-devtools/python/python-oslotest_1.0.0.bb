DESCRIPTION = "OpenStack test framework and test fixtures. \
The oslotest package can be cross-tested against its consuming projects to ensure \
that no changes to the library break the tests in those other projects."
HOMEPAGE = "https://pypi.python.org/pypi/oslotest"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

PR = "r0"
SRCNAME = "oslotest"

SRC_URI = "https://pypi.python.org/packages/source/o/${SRCNAME}/${SRCNAME}-1.0.0.tar.gz \
"

SRC_URI[md5sum] = "1f7710e4d38b615990737f813704fd58"
SRC_URI[sha256sum] = "cf05f4ff0cbf84ad0b5d1bef7c46d719eaf4408107e65a32a4500cf707d1a1e7"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

RDEPENDS_${PN} = "python-fixtures \
                  python-subunit \
                  python-testrepository \
                  python-testscenarios \
                  python-testtools \
                  python-mock \
                  python-mox \
"
