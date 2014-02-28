PRINC := "${@int(PRINC) + 1}"

inherit update-rc.d

do_install () {
	#oe_runmake DESTDIR="${D}" install_user

	install -d ${D}${sysconfdir}/iscsi/ifaces
	install -d ${D}${sysconfdir}/init.d
	install -d ${D}${base_sbindir}

	install -p -m 755 ${S}/usr/iscsid ${S}/usr/iscsiadm \
		${S}/utils/iscsi-iname \
		${S}/usr/iscsistart ${D}/${base_sbindir}

	install -m 755 ${S}/usr/iscsid ${D}${base_sbindir}
	install -m 755 ${S}/usr/iscsiadm ${D}${base_sbindir}
	install -m 755 ${S}/utils/iscsi-iname ${D}${base_sbindir}
	install -m 755 ${S}/utils/iscsi_discovery ${D}${base_sbindir}

	install -p -m 644 ${S}/etc/iscsid.conf ${D}${sysconfdir}/iscsi/
	install -p -m 644 ${S}/etc/iface.example ${D}${sysconfdir}/iscsi/ifaces/
	install -p -m 755 ${S}/etc/initd/initd.debian ${D}${sysconfdir}/init.d/open-iscsi
}

pkg_postinst_${PN} () {
	if [ "x$D" != "x" ]; then
		exit 1
	fi
	if [ ! -f /etc/iscsi/initiatorname.iscsi ]; then
		echo "InitiatorName=$(/sbin/iscsi-iname)" > \
		/etc/iscsi/initiatorname.iscsi
	fi
}

INITSCRIPT_NAME = "open-iscsi"
INITSCRIPT_PARAMS = "start 30 1 2 3 4 5 . stop 70 0 1 2 3 4 5 6 ."
