DESCRIPTION = "A repository of test results"
HOMEPAGE = "https://pypi.python.org/pypi/testrepository/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=f19071a777e237c55ec3ab83284b31b8"

SRCNAME = "testrepository"

SRC_URI = "https://pypi.python.org/packages/source/t/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "f648b0aceeca4fcd5f8a62eeedea289b"
SRC_URI[sha256sum] = "752449bc98c20253ec4611c40564aea93d435a5bf3ff672208e01cc10e5858eb"


S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

RDEPENDS_${PN} += "python-subunit \
                   python-extras \
"

CLEANBROKEN = "1"

