DESCRIPTION = "CLI and python client library for OpenStack Neutron"
HOMEPAGE = "https://launchpad.net/neutron"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

DEPENDS += " \
        python-pip \
        python-pbr \
        "

RDEPENDS_${PN} +="\
        python-pbr \
        python-cliff \
        python-iso8601 \
        python-netaddr \
        python-oslo.i18n \
        python-oslo.serialization \
        python-oslo.utils \
        python-requests \
        python-keystoneclient \
        python-simplejson \
        python-six \
        python-babel \
	"

SRC_URI = "git://github.com/openstack/python-neutronclient.git;branch=master \
           file://neutronclient-use-csv-flag-instead-of-json.patch \
           file://neutron-api-check.sh \
          "

PV = "3.1.0+git${SRCPV}"
SRCREV = "3e115991c1cf9ec7cf4252440fa8d6015a5f53ce"
S = "${WORKDIR}/git"

inherit setuptools monitor rmargparse

PACKAGECONFIG ?= "bash-completion"
PACKAGECONFIG[bash-completion] = ",,bash-completion,bash-completion ${BPN}-bash-completion"

do_install_append() {
	install -d ${D}/${sysconfdir}/bash_completion.d
	install -m 664 ${S}/tools/neutron.bash_completion ${D}/${sysconfdir}/bash_completion.d
}

PACKAGES =+ "${BPN}-bash-completion"
FILES_${BPN}-bash-completion = "${sysconfdir}/bash_completion.d/*"

MONITOR_CHECKS_${PN} += "\
	neutron-api-check.sh \
"
