DESCRIPTION = "Client library for OpenStack Cinder API."
HOMEPAGE = "https://github.com/openstack/python-cinderclient"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3572962e13e5e739b30b0864365e0795"
DEPENDS = "python3-setuptools-git"

SRCNAME = "python-cinderclient"

SRC_URI = "\
	git://github.com/openstack/python-cinderclient.git;branch=stable/zed;protocol=https \
	file://cinder-api-check.sh \
	"

PV="9.1.0+git${SRCPV}"
SRCREV="730a8c7728a8481d4c74e4c93b2619025f7267ea"
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
        python3-prettytable \
        python3-keystoneauth1 \
        python3-simplejson \
        python3-babel \
        python3-six \
        python3-oslo.i18n \
        python3-oslo.utils \
        bash \
        "
	
PACKAGECONFIG ?= "bash-completion"
PACKAGECONFIG[bash-completion] = ",,bash-completion,bash-completion ${BPN}-bash-completion"

do_install:append() {
	install -d ${D}/${sysconfdir}/bash_completion.d
	install -m 664 ${S}/tools/cinder.bash_completion ${D}/${sysconfdir}/bash_completion.d
}

PACKAGES =+ "${BPN}-bash-completion"
FILES:${BPN}-bash-completion = "${sysconfdir}/bash_completion.d/*"

MONITOR_CHECKS_${PN} += "\
	cinder-api-check.sh \
"
