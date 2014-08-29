FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://iptables-nat.scc \
	file://enable-veth.cfg \
	"

