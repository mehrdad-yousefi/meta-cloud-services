SUMMARY = "Common testing tools used in the Salt Stack projects"
HOMEPAGE = "https://github.com/saltstack/salt-testing"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f36f1e9e3e30f90180efdf7e40d943e5"

SRC_URI = "git://github.com/saltstack/salt-testing.git;branch=develop;tag=v2018.9.21 \
           file://0001-Add-ptest-output-option-to-test-suite.patch \
           "

PV = "2018.9.21+git${SRCPV}"

S = "${WORKDIR}/git"

RDEPENDS_${PN} = "\
                  python3-mock \
                  python3-unittest \
"

inherit setuptools3
