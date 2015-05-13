SUMMARY = "Oslo Policy library"
DESCRIPTION = "The Oslo Policy library provides support for RBAC policy enforcement across all OpenStack services."
HOMEPAGE = "https://pypi.python.org/pypi/oslo.policy"
SECTION = "devel/python"
LICENSE = "Apache-2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"


SRCNAME = "oslo.policy"
SRC_URI = "http://pypi.python.org/packages/source/o/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "a0ddfa5782191c218e1e100234550295"
SRC_URI[sha256sum] = "7e8a82e617516722043f437825ed5ada422632ee432cc64ede7c4854209cd329"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

DEPENDS += " \
        python-pip \
"

RDEPENDS_${PN} += " \
        python-oslo.config \
        python-oslo.i18n \
        python-oslo.serialization \
"
