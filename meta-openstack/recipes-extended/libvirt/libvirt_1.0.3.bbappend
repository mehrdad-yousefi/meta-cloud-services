PACKAGECONFIG ?= "qemu lxc test remote macvtap libvirtd udev yajl \
	 	 python numactl sanlock ebtables \
		 ${@base_contains('DISTRO_FEATURES', 'selinux', 'selinux', '', d)} \
		"
