IMAGE_FEATURES += "ssh-server-openssh package-management"
EXTRA_IMAGE_FEATURES = "tools-debug debug-tweaks"

IMAGE_INSTALL = "\
    ${CORE_IMAGE_BASE_INSTALL} \
    ${ROOTFS_PKGMANAGE_BOOTSTRAP} \
    packagegroup-core-basic \
    python-nova \
    python-novaclient \
    python-glance \
    python-keystone \
    qpid \
    qpid-python \
    "

inherit core-image

# Ensure extra space for guest images
#IMAGE_ROOTFS_EXTRA_SPACE = "41943040"
