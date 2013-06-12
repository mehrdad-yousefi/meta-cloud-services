SUMMARY = "Configuration for OpenStack Compute node"
PR = "r0"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS_${PN} = " qemu \
    libvirt \
    libvirt-libvirtd \
    libvirt-virsh \
    kernel-module-kvm \
    kernel-module-kvm-intel \
    kernel-module-kvm-amd \
    kernel-module-nbd \
    nova-compute \
    python-novaclient \
    quantum-plugin-openvswitch \
    openvswitch-switch \
    "

