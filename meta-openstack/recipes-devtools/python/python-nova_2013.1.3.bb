include python-nova.inc

inherit useradd

pkg_postinst_${SRCNAME}-common () {
    if [ "x$D" != "x" ]; then
        exit 1
    fi

    echo "source /etc/nova/openrc" > /home/root/.bashrc
}

PACKAGES += "${SRCNAME}-common ${SRCNAME}-common-misc"

#FILES_${PN} = "${files_${PN}}"
#
#FILES_${SRCNAME}-common = "${files_${SRCNAME}-common}"
#
#FILES_${SRCNAME}-common-misc = "${files_${SRCNAME}-compute} ${files_${SRCNAME}-controller}"

FILES_${PN} = "${libdir}/python*"

FILES_${SRCNAME}-common = " \
	${bindir}/nova-manage \
	${bindir}/nova-rootwrap \
	${sysconfdir}/sudoers.d"

FILES_${SRCNAME}-common-misc = " \
	${bindir}/nova-compute \
	${sysconfdir}/${SRCNAME}/* \
	${sysconfdir}/init.d/nova-compute \
	${bindir} \
	${sysconfdir}/init.d/nova-all"

RDEPENDS_${SRCNAME}-common = "${PN} openssl openssl-misc libxml2 libxslt \
        iptables curl dnsmasq sudo procps"

USERADD_PACKAGES = "${PN}"
GROUPADD_PARAM_${PN} = "--system nova"
USERADD_PARAM_${PN}  = "--system --home /var/lib/nova -g nova \
                        --no-create-home --shell /bin/false nova"

RDEPENDS_${PN} = " python-modules \
    python-misc \
    python-argparse \
    python-amqplib \
    python-anyjson \
    python-babel \
    python-boto \
    python-cinderclient \
    python-cheetah \
    python-eventlet \
    python-feedparser \
    python-glanceclient \
    python-greenlet \
    python-httplib2 \
    python-iso8601 \
    python-kombu \
    python-lxml \
    python-netaddr \
    python-oslo.config \
    python-paste \
    python-pastedeploy \
    python-paramiko \
    python-pyasn1 \
    python-setuptools-git \
    python-simplejson \
    python-setuptools \
    python-sqlalchemy \
    python-sqlalchemy-migrate \
    python-stevedore \
    python-suds \
    python-quantumclient \
    python-routes \
    python-webob \
    python-websockify \
    "
