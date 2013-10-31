SUMMARY = "Configuration for OpenStack Compute node"
PR = "r0"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit packagegroup

RDEPENDS_${PN} = " qemu \
    libvirt \
    libvirt-libvirtd \
    libvirt-virsh \
    nova-compute \
    python-novaclient \
    neutron-plugin-openvswitch \
    openvswitch-switch \
    "

RRECOMMENDS_${PN} = " \
    kernel-module-kvm \
    kernel-module-kvm-intel \
    kernel-module-kvm-amd \
    kernel-module-nbd \
    "
