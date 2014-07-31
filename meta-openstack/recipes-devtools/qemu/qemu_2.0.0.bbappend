PACKAGECONFIG[spice] = "--enable-spice,--disable-spice,spice,"

PACKAGECONFIG ?= "spice virtfs attr cap-ng"
PACKAGECONFIG_class-native = ""
PACKAGECONFIG_class-nativesdk = ""