DESCRIPTION = "oslo.vmware library"
HOMEPAGE = "http://launchpad.net/oslo"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

PV = "2.14.0+git${SRCPV}"
SRCREV = "bfd1e0ffd435e637d00ba54ec99aeafe4488eca1"

SRCNAME = "oslo.vmware"
SRC_URI = "git://github.com/openstack/${SRCNAME}.git;branch=stable/newton"

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
        python-six \
        python-oslo.i18n \
        python-oslo.utils \
        python-oslo.concurrency \
        python-pyyaml \
        python-lxml \
        python-suds-jurko \
        python-eventlet \
        python-requests \
        python-urllib3 \
        "
