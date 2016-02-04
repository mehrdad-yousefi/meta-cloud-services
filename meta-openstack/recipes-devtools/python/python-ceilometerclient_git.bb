DESCRIPTION = "CLI and python client library for OpenStack Ceilometer"
HOMEPAGE = "https://launchpad.net/ceilometer"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

DEPENDS += " \
        python-pip \
        python-pbr \
        "

RDEPENDS_${PN} +=" \
        python-cliff \
	python-httplib2 \
	python-iso8601 \
	python-prettytable \
	python-pyparsing \
	python-simplejson \
	python-pbr \
        python-oslo.i18n \
        python-oslo.serialization \
        python-oslo.utils \
        python-keystoneclient \
        python-requests \
        python-six \
        python-stevedore \
	"

SRC_URI = "\
	git://github.com/openstack/python-ceilometerclient.git;branch=master \
	file://fix_ceilometerclient_memory_leak.patch \
	"

PV = "1.5.0+git${SRCPV}"
SRCREV = "daed7e59c383f1ca74d75160cbc99fbd89675648"
S = "${WORKDIR}/git"

inherit setuptools rmargparse


PACKAGECONFIG ?= "bash-completion"
PACKAGECONFIG[bash-completion] = ",,bash-completion,bash-completion ${BPN}-bash-completion"

do_install_append() {
	install -d ${D}/${sysconfdir}/bash_completion.d
	install -m 664 ${S}/tools/ceilometer.bash_completion ${D}/${sysconfdir}/bash_completion.d
}

PACKAGES =+ "${BPN}-bash-completion"
FILES_${BPN}-bash-completion = "${sysconfdir}/bash_completion.d/*"
