FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
PRINC := "${@int(PRINC) + 1}"

SRC_URI += "file://iscsi-tcp.scc \
	file://enable-iscsi-tcp.cfg \
	"
