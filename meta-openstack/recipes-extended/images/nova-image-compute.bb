DESCRIPTION = "Openstack compute node image"
LICENSE = "MIT"

IMAGE_INSTALL = " \
    packagegroup-core-boot \
    ${ROOTFS_PKGMANAGE_BOOTSTRAP} \
    packagegroup-cloud-compute \
    "

IMAGE_FEATURES += "ssh-server-openssh"

inherit core-image

#IMAGE_ROOTFS_EXTRA_SPACE = "41943040"

ROOTFS_POSTPROCESS_COMMAND += "remove_packaging_data_files ; "
