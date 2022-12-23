DESCRIPTION = "CLI and python client library for OpenStack Neutron"
HOMEPAGE = "https://launchpad.net/neutron"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

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
        python-cliff \
        python3-debtcollector \
        python3-iso8601 \
        python3-netaddr \
        python-osc-lib \
        python3-oslo.i18n \
        python3-oslo.serialization \
        python3-oslo.utils \
        python-os-client-config \
        python3-keystoneauth1 \
        python3-keystoneclient \
        python3-requests \
        python3-simplejson \
        python3-six \
        python3-babel \
        bash \
        "

SRC_URI = "git://github.com/openstack/python-neutronclient.git;branch=stable/pike;protocol=https \
           file://neutronclient-use-csv-flag-instead-of-json.patch \
           file://neutron-api-check.sh \
          "

PV = "6.5.0+git${SRCPV}"
SRCREV = "e145c4ef8a0e8390f0468df422a757760e77f823"
S = "${WORKDIR}/git"

inherit setuptools3 monitor rmargparse

PACKAGECONFIG ?= "bash-completion"
PACKAGECONFIG[bash-completion] = ",,bash-completion,bash-completion ${BPN}-bash-completion"

do_install:append() {
	install -d ${D}/${sysconfdir}/bash_completion.d
	install -m 664 ${S}/tools/neutron.bash_completion ${D}/${sysconfdir}/bash_completion.d
}

PACKAGES =+ "${BPN}-bash-completion"
FILES:${BPN}-bash-completion = "${sysconfdir}/bash_completion.d/*"

MONITOR_CHECKS_${PN} += "\
	neutron-api-check.sh \
"
