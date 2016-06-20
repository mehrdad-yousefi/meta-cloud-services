SUMMARY = "Common testing tools used in the Salt Stack projects"
HOMEPAGE = "https://github.com/saltstack/salt-testing"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f36f1e9e3e30f90180efdf7e40d943e5"
SRCNAME = "salt-testing"

SRC_URI = "https://github.com/saltstack/salt-testing/archive/v${PV}.tar.gz;downloadfilename=salt-testing-v${PV}.tar.gz"
SRC_URI[md5sum] = "8ca55a796e9ad7ba72bc143043753ccf"
SRC_URI[sha256sum] = "0ef4be6a8a9b505ae1c328394dfad50493674af6100c7e2c220f374533d86edc"

S = "${WORKDIR}/${SRCNAME}-${PV}"

RDEPENDS_${PN} = "\
                  python-mock \
                  python-unittest \
"

inherit setuptools

