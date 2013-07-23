FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
PRINC := "${@int(PRINC) + 1}"

SRC_URI += "file://iptables-nat.scc \
	file://enable-veth.cfg \
	"

