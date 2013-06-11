FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
PRINC := "${@int(PRINC) + 1}"

SRC_URI += "file://postgresql"

inherit useradd update-rc.d

do_install_append() {
    install -d ${D}${sysconfdir}/${PN}
    chown postgres ${D}${sysconfdir}/${PN}

    install -d ${D}${sysconfdir}/init.d/
    install -m 0755 ${WORKDIR}/postgresql ${D}${sysconfdir}/init.d/postgresql
}

USERADD_PACKAGES = "${PN}"
GROUPADD_PARAM_${PN} = "--system postgres"
USERADD_PARAM_${PN}  = "--system --home /var/lib/postgres -g postgres \
                        --no-create-home --shell /bin/false postgres"

pkg_postinst_${PN} () {
    if [ "x$D" != "x" ]; then
        exit 1
    fi

    sudo -u postgres initdb -D /etc/${PN}/
    #quick fix
    /etc/init.d/postgresql start
    sleep 1
    sudo -u postgres createuser -s nova
}

FILES_${PN} += "${localstatedir}/run/${PN}"

INITSCRIPT_NAME = "${PN}"
INITSCRIPT_PARAMS = "defaults"
