SUMMARY = "Configuration for OpenStack Network node"
PR = "r0"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS_${PN} = " \
    quantum-plugin-openvswitch \
    quantum-dhcp-agent \
    quantum-l3-agent \
    openvswitch-switch \
    "
