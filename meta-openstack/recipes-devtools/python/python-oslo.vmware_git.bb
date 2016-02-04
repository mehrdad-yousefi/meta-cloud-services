DESCRIPTION = "oslo.vmware library"
HOMEPAGE = "http://launchpad.net/oslo"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

PV = "1.23.0+git${SRCPV}"
SRCREV = "9fa40986c259d22a3dee8155b4bce793505d53e1"

SRCNAME = "oslo.vmware"
SRC_URI = "git://github.com/openstack/${SRCNAME}.git"

S = "${WORKDIR}/git"

inherit setuptools

DEPENDS += " \
        python-pip \
        python-pbr \
        "

RDEPENDS_${PN} += " \
        python-pbr \
        python-stevedore \
        python-netaddr \
        python-iso8601 \
        python-six \
        python-oslo.i18n \
        python-oslo.utils \
        python-oslo.concurrency \
        python-babel \
        python-pyyaml \
        python-suds-jurko \
        python-eventlet \
        python-requests \
        python-urllib3 \
        "
