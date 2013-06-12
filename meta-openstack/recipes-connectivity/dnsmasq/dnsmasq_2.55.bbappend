do_install_append() {
    cd ${S}/contrib/wrt
    oe_runmake

    install -m 0755 ${S}/contrib/wrt/dhcp_release ${D}${bindir}
}



