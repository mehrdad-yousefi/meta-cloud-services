FILESEXTRAPATHS:append := "${THISDIR}/${PN}"

RRECOMMENDS:${PN} += "kernel-module-veth \
	"
