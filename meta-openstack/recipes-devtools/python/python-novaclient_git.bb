DESCRIPTION = "Client library for OpenStack Compute API"
HOMEPAGE = "https://github.com/openstack/python-novaclient"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7cdb54622cacc9bc9b2883091e6dd669"

PR = "r0"

SRC_URI = "\
	git://github.com/openstack/python-novaclient.git;branch=master \
	file://fix_novaclient_memory_leak.patch \
	file://novaclient-specify-full-path-to-test-certificate.patch \
	file://nova-api-check.sh \
	"

PV="2.20.0+git${SRCPV}"
SRCREV="1eb1abe8700a137d017dbcd4a9dab3d4c0879c81"
S = "${WORKDIR}/git"

inherit setuptools monitor

DEPENDS = "python-setuptools-git"
DEPENDS += " \
        python-pip \
        python-pbr \
        "

RDEPENDS_${PN} += "python-iso8601 \
	python-prettytable \
	python-requests \
	python-simplejson \
	python-pbr \
	"

PACKAGECONFIG ?= "bash-completion"
PACKAGECONFIG[bash-completion] = ",,bash-completion,bash-completion ${BPN}-bash-completion"

do_install_append() {
	install -d ${D}/${sysconfdir}/bash_completion.d
	install -m 664 ${S}/tools/nova.bash_completion ${D}/${sysconfdir}/bash_completion.d

	sed -e "s:%PYTHON_SITEPACKAGES_DIR%:${PYTHON_SITEPACKAGES_DIR}:g" \
	    -i ${D}/${PYTHON_SITEPACKAGES_DIR}/novaclient/tests/v1_1/test_servers.py
}

PACKAGES =+ "${BPN}-bash-completion"
FILES_${BPN}-bash-completion = "${sysconfdir}/bash_completion.d/*"

MONITOR_CHECKS_${PN} += "\
	nova-api-check.sh \
"
