DESCRIPTION = "Oslo utils"
HOMEPAGE = "https://launchpad.net/oslo"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

SRCNAME = "oslo.utils"
SRC_URI = "git://github.com/openstack/${SRCNAME}.git"

PV = "2.7.0+git${SRCPV}"
SRCREV = "6aa24675e890e0bb61967a3e4c5e6aa8cf3dedcf"
S = "${WORKDIR}/git"

inherit setuptools

# DEPENDS_default: python-pip

DEPENDS += " \
        python-pip \
        python-pbr \
        "

# RDEPENDS_default: 
RDEPENDS_${PN} += " \
        python-pbr \
        python-babel \
        python-six \
        python-iso8601 \
        python-oslo.i18n \
        python-monotonic \
        python-pytz \
        python-netaddr \
        python-netifaces \
        python-debtcollector \
        "
