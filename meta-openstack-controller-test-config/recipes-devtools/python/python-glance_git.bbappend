FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += " file://glance-test-config.init"

do_install:append() {
    install -m 0755 ${WORKDIR}/glance-test-config.init ${D}${sysconfdir}/init.d/glance-test-config
}

PACKAGES += " ${SRCNAME}-test-config"
FILES:${SRCNAME}-test-config = "${sysconfdir}/init.d/glance-test-config"

RDEPENDS:${SRCNAME}-tests += " ${SRCNAME}-test-config"

INITSCRIPT_PACKAGES += " ${SRCNAME}-test-config"
INITSCRIPT_NAME:${SRCNAME}-test-config = "glance-test-config"
INITSCRIPT_PARAMS:${SRCNAME}-test-config = "defaults 95 10"
