DESCRIPTION = "Openstack compute node image"
LICENSE = "MIT"

IMAGE_INSTALL = " \
    packagegroup-core-boot \
    ${ROOTFS_PKGMANAGE_BOOTSTRAP} \
    packagegroup-cloud-compute \
    "

IMAGE_FEATURES += "ssh-server-openssh"

inherit core-image
inherit openstack-base

# Ensure extra space for guest images, and rabbit MQ has a hard coded
# check for 2G of free space, so we use 3G as a starting point.
IMAGE_ROOTFS_EXTRA_SPACE = "3000000"

ROOTFS_POSTPROCESS_COMMAND += "remove_packaging_data_files ; "
