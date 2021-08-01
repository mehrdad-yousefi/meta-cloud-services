PACKAGECONFIG[spice] = "--enable-spice,--disable-spice,spice,"
PACKAGECONFIG[libseccomp] = "--enable-seccomp,--disable-seccomp,libseccomp,libseccomp"

PACKAGECONFIG ?= "fdt virtfs libcap-ng"
PACKAGECONFIG:x86 ?= "fdt spice virtfs libcap-ng"
PACKAGECONFIG:x86-64 ?= "fdt spice virtfs libcap-ng"

PACKAGECONFIG:class-native = "fdt"
PACKAGECONFIG:class-nativesdk = "fdt"
