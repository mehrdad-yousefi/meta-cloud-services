FILESEXTRAPATHS_append := "${THISDIR}/${PN}"

RRECOMMENDS_${PN} += "kernel-module-veth \
	"

SRC_URI += " file://0003-Don-t-enforce-that-dev-already-exists.patch"
