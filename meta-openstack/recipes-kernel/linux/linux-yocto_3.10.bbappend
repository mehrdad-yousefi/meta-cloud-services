FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://iscsi-tcp.scc \
	file://enable-iscsi-tcp.cfg \
	"
