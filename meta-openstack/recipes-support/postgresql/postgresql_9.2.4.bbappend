FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
PRINC := "${@int(PRINC) + 1}"

SRC_URI += "file://postgresql"

inherit useradd update-rc.d identity

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
    # postgres 9.2.4 postinst
    if [ "x$D" != "x" ]; then
        exit 1
    fi

    sudo -u postgres initdb -D /etc/${PN}/
    sleep 2
    /etc/init.d/postgresql start
    sleep 5

    count=0
    done=0
    while [ $count -le 10 ] && [ $done -eq 0 ]; do
	sudo -u postgres psql -c "CREATE ROLE ${DB_USER} WITH SUPERUSER LOGIN PASSWORD '${DB_PASSWORD}'" 2> /dev/null
	if [ $? -ne 0 ]; then
            echo "[INFO] postgres: failed to create account for ${DB_USER}, trying again"
            /etc/init.d/postgresql stop
	    sleep 2
            /etc/init.d/postgresql start
	    sleep 1
	else
            done=1
	fi
	count=`expr $count + 1`
    done

    if [ $done -eq 0 ]; then
	echo "[ERROR] postgres: unable to create admin account"
	exit 1
    fi

    ln -s /usr/share/zoneinfo /usr/share/postgresql/timezone
    # end postgres 9.2.4 postinst
}

FILES_${PN} += "${localstatedir}/run/${PN}"

INITSCRIPT_NAME = "${PN}"
INITSCRIPT_PARAMS = "defaults"
