SUMMARY = "An image containing the cirros cloud guest"
DESCRIPTION = "CirrOS a tiny cloud guest"
HOMEPAGE = "https://launchpad.net/cirros"

LICENSE="GPLv2"

SRC_URI = "https://launchpad.net/cirros/trunk/0.3.0/+download/${PN}-${PV}-x86_64-disk.img"
SRC_URI[md5sum] = "5005e29ebadd0644af9008657fead245"
SRC_URI[sha256sum] = "4820b23e33f388f3b95766fb67a6a211b111ab8349f41e2274b471bd288be21a"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"


do_install() {
	     install -d ${D}/root/images
	     install -m 755 ${WORKDIR}/${PN}-${PV}-x86_64-disk.img ${D}/root/images
}

PACKAGES = "cirros-guest-image"
FILES_cirros-guest-image = "/root/images/*"
