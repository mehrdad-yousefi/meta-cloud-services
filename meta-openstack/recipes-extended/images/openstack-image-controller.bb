DESCRIPTION = "Openstack controller node image"
LICENSE = "MIT"

OPENSTACK_CONTROLLER_EXTRA_INSTALL ?= ""

IMAGE_INSTALL = "\
    ${CORE_IMAGE_BASE_INSTALL} \
    ${ROOTFS_PKGMANAGE_BOOTSTRAP} \
    packagegroup-core-basic \
    packagegroup-cloud-controller \
    packagegroup-cloud-network \
    ${OPENSTACK_CONTROLLER_EXTRA_INSTALL} \
    "

IMAGE_FEATURES += " ssh-server-openssh"

inherit core-image
inherit openstack-base

# Ensure extra space for guest images, and rabbit MQ has a hard coded
# check for 2G of free space, so we use 3G as a starting point.
IMAGE_ROOTFS_EXTRA_SPACE = "3000000"
