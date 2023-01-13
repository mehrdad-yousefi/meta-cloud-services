DESCRIPTION = "Client library for OpenStack Compute API"
HOMEPAGE = "https://github.com/openstack/python-novaclient"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7cdb54622cacc9bc9b2883091e6dd669"

SRC_URI = "\
	git://github.com/openstack/python-novaclient.git;branch=stable/zed;protocol=https \
	file://nova-api-check.sh \
	"

PV = "18.1.0+git${SRCPV}"
SRCREV = "be9517cb027d960caf4c9c8171b3ad2568bedae9"
S = "${WORKDIR}/git"

inherit setuptools3 monitor

DEPENDS += " \
        python3-pip \
        python3-pbr \
        "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python3-pbr-native \
        "

RDEPENDS:${PN} += " \
        python3-pbr \
        python3-keystoneauth1 \
        python3-iso8601 \
        python3-oslo.i18n \
        python3-oslo.serialization \
        python3-oslo.utils \
        python3-prettytable \
        python3-simplejson \
        python3-six \
        python3-babel \
        bash \
        "

MONITOR_CHECKS_${PN} += "\
	nova-api-check.sh \
"
