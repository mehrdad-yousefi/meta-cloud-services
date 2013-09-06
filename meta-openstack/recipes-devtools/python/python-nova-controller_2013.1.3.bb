include python-nova.inc

PR = "r0"

FILESEXTRAPATHS := "${THISDIR}/${PYTHON_PN}"

SRC_URI += "file://nova-all \
            file://nova.conf \
            file://openrc \
           "

inherit controller update-rc.d

PACKAGES = "${SRCNAME}-controller ${SRCNAME}-controller-misc"
# PACKAGES = "${SRCNAME}-controller-misc ${SRCNAME}-controller"

do_install_append() {
    if ${@base_contains('DISTRO_FEATURES', 'sysvinit', 'true', 'false', d)}; then
        install -d ${D}${sysconfdir}/init.d
        install -m 0755 ${WORKDIR}/nova-all ${D}${sysconfdir}/init.d/nova-all
    fi
}

pkg_postinst_${SRCNAME}-controller () {
    if [ "x$D" != "x" ]; then
        exit 1
    fi

    # This is to make sure postgres is configured and running
    if ! pidof postmaster > /dev/null; then
       sudo -u postgres initdb -D /etc/postgresql/
       /etc/init.d/postgresql start
       sleep 0.2
       sudo -u postgres psql -c "CREATE ROLE ${DB_USER} WITH SUPERUSER LOGIN PASSWORD '${DB_PASSWORD}'"
    fi

    sudo -u postgres createdb nova
    nova-manage db sync
}

# FILES_${SRCNAME}-controller = "${files_${SRCNAME}-controller}"
FILES_${SRCNAME}-controller = "${bindir}/* \
			       ${sysconfdir}/${SRCNAME}/* \
			       ${sysconfdir}/init.d/nova-all"

# If the compute is built, so we package it out of the way
# FILES_${SRCNAME}-controller-misc = "${files_${SRCNAME}-compute} ${files_${SRCNAME}-common} ${files_${PYTHON_PN}}"
FILES_${SRCNAME}-controller-misc = "${libdir}/*\
				    ${bindir}/nova-compute \
				    ${sysconfdir}/${SRCNAME}/* \
				    ${sysconfdir}/init.d/nova-compute \
				    ${bindir}/nova-manage \
				    ${bindir}/nova-rootwrap \
				    ${sysconfdir}/sudoers.d"

RDEPENDS_${SRCNAME}-controller = "${PYTHON_PN} ${SRCNAME}-common \
                                  postgresql postgresql-client python-psycopg2"

RCONFLICTS_${SRCNAME}-controller = "${SRCNAME}-compute"

INITSCRIPT_PACKAGES = "${SRCNAME}-controller"
INITSCRIPT_NAME_${SRCNAME}-controller = "nova-all"
