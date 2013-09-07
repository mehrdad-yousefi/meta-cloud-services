
include python-nova.inc

PR = "r0"

FILESEXTRAPATHS := "${THISDIR}/${PYTHON_PN}"

SRC_URI += "file://nova-compute \
            file://nova.conf \
            file://openrc \
           "

inherit compute update-rc.d

PACKAGES = "${PN} ${SRCNAME}-compute ${SRCNAME}-compute-misc"

do_install_append() {
    if ${@base_contains('DISTRO_FEATURES', 'sysvinit', 'true', 'false', d)}; then
        install -d ${D}${sysconfdir}/init.d
        install -m 0755 ${WORKDIR}/nova-compute ${D}${sysconfdir}/init.d/nova-compute
    fi
}

#FILES_${SRCNAME}-compute = " ${files_${SRCNAME}-compute}"
#
# the controller is built, so we package it out of the way

#FILES_${SRCNAME}-compute-misc = "${files_${SRCNAME}-controller} 
#${files_${SRCNAME}-common} ${files_${PYTHON_PN}}"

FILES_${PN} = "${libdir}/python*"

FILES_${SRCNAME}-compute = " \
	${bindir}/nova-compute \
	${sysconfdir}/${SRCNAME}/* \
	${sysconfdir}/init.d/nova-compute"

FILES_${SRCNAME}-compute-misc = " \
	${bindir} \
	${sysconfdir}/init.d/nova-all \
	${bindir}/nova-manage \
	${bindir}/nova-rootwrap \
	${sysconfdir}/sudoers.d"

RDEPENDS_${SRCNAME}-compute = "${PYTHON_PN} ${SRCNAME}-common \
                               qemu libvirt libvirt-libvirtd libvirt-python libvirt-virsh"

RCONFLICTS_${SRCNAME}-compute = "${SRCNAME}-controller"

INITSCRIPT_PACKAGES = "${SRCNAME}-compute"
INITSCRIPT_NAME_${SRCNAME}-compute = "nova-compute"
