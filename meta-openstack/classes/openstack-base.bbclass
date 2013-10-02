inherit hosts

ROOTFS_POSTPROCESS_COMMAND += "openstack_configure_hosts ; "

openstack_configure_hosts() {
    bbnote "openstack: identifying hosts"

    echo "${CONTROLLER_IP} controller" >> ${IMAGE_ROOTFS}/etc/hosts
    echo "${COMPUTE_IP} compute" >> ${IMAGE_ROOTFS}/etc/hosts
    echo "${MY_HOST}" > ${IMAGE_ROOTFS}/etc/hostname
}

