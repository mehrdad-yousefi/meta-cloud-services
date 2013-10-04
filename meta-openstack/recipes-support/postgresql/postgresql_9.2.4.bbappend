FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
PRINC := "${@int(PRINC) + 1}"

SRC_URI += "file://postgresql \
            file://postgresql-init"

inherit useradd update-rc.d identity hosts

do_install_append() {
    install -d ${D}${sysconfdir}/${PN}
    chown postgres ${D}${sysconfdir}/${PN}

    install -d ${D}${sysconfdir}/init.d/
    install -m 0755 ${WORKDIR}/postgresql ${D}${sysconfdir}/init.d/postgresql

    sed -e "s:%DB_USER%:${DB_USER}:g" -i ${WORKDIR}/postgresql-init
    sed -e "s:%DB_PASSWORD%:${DB_PASSWORD}:g" -i ${WORKDIR}/postgresql-init

    sed -e "s:%CONTROLLER_IP%:${CONTROLLER_IP}:g" -i ${WORKDIR}/postgresql-init
    sed -e "s:%CONTROLLER_HOST%:${CONTROLLER_HOST}:g" -i ${WORKDIR}/postgresql-init

    sed -e "s:%COMPUTE_IP%:${COMPUTE_IP}:g" -i ${WORKDIR}/postgresql-init
    sed -e "s:%COMPUTE_HOST%:${COMPUTE_HOST}:g" -i ${WORKDIR}/postgresql-init

    install -m 0755 ${WORKDIR}/postgresql-init ${D}${sysconfdir}/init.d/postgresql-init

}

RDEPENDS_${PN} += "postgresql-timezone eglibc-utils update-rc.d"
USERADD_PACKAGES = "${PN}"
GROUPADD_PARAM_${PN} = "--system postgres"
USERADD_PARAM_${PN}  = "--system --home /var/lib/postgres -g postgres \
                        --no-create-home --shell /bin/false postgres"

pkg_postinst_${PN} () {
    # postgres 9.2.4 postinst
    if [ "x$D" != "x" ]; then
        exit 1
    fi

    /etc/init.d/postgresql-init
    if [ $? -eq 0 ]; then
	echo "[ERROR] postgres: unable to create admin account"
	exit 1
    fi
}

FILES_${PN} += "${localstatedir}/run/${PN}"

INITSCRIPT_NAME = "${PN}"
INITSCRIPT_PARAMS = "defaults"
