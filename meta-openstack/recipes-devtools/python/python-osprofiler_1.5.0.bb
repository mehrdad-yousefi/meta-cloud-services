DESCRIPTION = "OpenStack Profiler Library"
HOMEPAGE = "http://www.openstack.org/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=19cbd64715b51267a47bf3750cc6a8a5"

SRCNAME = "osprofiler"
SRC_URI = "http://pypi.io/packages/source/o/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "6762b5420fd95646a26c4eaca1af9e64"
SRC_URI[sha256sum] = "aee63cfd888e6049ea82535ce458ce4844b4ac893dcb18060eda24192505627e"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

# DEPENDS_default: python-pip

DEPENDS += " \
        python-pip \
        python-pbr \
        "

# RDEPENDS_default: 
RDEPENDS_${PN} += " \
        python-pbr \
        python-six \
        python-oslo.messaging \
        python-oslo.log \
        python-oslo.utils \
        python-webob \
        python-requests \
        python-netaddr \
        python-oslo.concurrency \
        "
