PACKAGECONFIG[spice] = "--enable-spice,--disable-spice,spice,"
PACKAGECONFIG[libseccomp] = "--enable-seccomp,--disable-seccomp,libseccomp,libseccomp"

PACKAGECONFIG ?= "fdt spice virtfs libcap-ng"
PACKAGECONFIG_class-native = "fdt"
PACKAGECONFIG_class-nativesdk = "fdt"
