SUMMARY = "An image containing the cirros cloud guest"
DESCRIPTION = "CirrOS a tiny cloud guest"
HOMEPAGE = "https://launchpad.net/cirros"

LICENSE="GPLv2"

SRC_URI = "https://launchpad.net/cirros/trunk/${PV}/+download/${PN}-${PV}-x86_64-disk.img"
SRC_URI[md5sum] = "50bdc35edb03a38d91b1b071afb20a3c"
SRC_URI[sha256sum] = "648782e9287288630250d07531fed9944ecc3986764a6664f0bf6c050ec06afd"

LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

INHIBIT_PACKAGE_STRIP="1"

do_install() {
	     install -d ${D}/root/images
	     install -m 755 ${WORKDIR}/${PN}-${PV}-x86_64-disk.img ${D}/root/images
}

PACKAGES = "cirros-guest-image"
FILES_cirros-guest-image = "/root/images/*"
