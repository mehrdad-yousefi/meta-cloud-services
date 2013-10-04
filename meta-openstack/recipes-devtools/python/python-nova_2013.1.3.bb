DESCRIPTION = "Nova is a cloud computing fabric controller"
HOMEPAGE = "https://launchpad.net/nova"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

DEPENDS = "sudo"

PR = "r0"
SRCNAME = "nova"

FILESEXTRAPATHS := "${THISDIR}/${PN}"

SRC_URI = "https://launchpad.net/${SRCNAME}/grizzly/${PV}/+download/${SRCNAME}-${PV}.tar.gz \
           file://0001-nova-api-paste.ini-make-controller-IP-configurable.patch \
           "

SRC_URI += "file://nova-all \
            file://nova-consoleauth \
            file://nova-novncproxy \
            file://nova.conf \
            file://openrc \
           "

SRC_URI[md5sum] = "6215982b9ed08b9042e088470d60a0a6"
SRC_URI[sha256sum] = "f7c25186920daccb16867c5fd272318beb8cc076e5a55f79b5906618ef2724f4"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit update-rc.d setuptools identity hosts

do_install_append() {
    if [ ! -f "${WORKDIR}/nova.conf" ]; then
        return
    fi

    TEMPLATE_CONF_DIR=${S}${sysconfdir}/${SRCNAME}
    NOVA_CONF_DIR=${D}/${sysconfdir}/nova

    install -d ${NOVA_CONF_DIR}
    install -m 600 ${S}/etc/nova/policy.json ${NOVA_CONF_DIR}/

    # Deploy filters to /etc/nova/rootwrap.d
    install -m 755 -d ${NOVA_CONF_DIR}/rootwrap.d
    install -m 600 ${S}/etc/nova/rootwrap.d/*.filters ${NOVA_CONF_DIR}/rootwrap.d
    chown -R root:root ${NOVA_CONF_DIR}/rootwrap.d
    chmod 644 ${NOVA_CONF_DIR}/rootwrap.d

    # Set up rootwrap.conf, pointing to /etc/nova/rootwrap.d
    install -m 644 ${S}/etc/nova/rootwrap.conf ${NOVA_CONF_DIR}/
    sed -e "s:^filters_path=.*$:filters_path=${sysconfdir}/nova/rootwrap.d:" \
        -i ${NOVA_CONF_DIR}/rootwrap.conf
    chown root:root $NOVA_CONF_DIR/rootwrap.conf

    # Set up the rootwrap sudoers for nova
    install -d ${D}${sysconfdir}/sudoers.d
    touch ${D}${sysconfdir}/sudoers.d/nova-rootwrap
    chmod 0440 ${D}${sysconfdir}/sudoers.d/nova-rootwrap
    chown root:root ${D}${sysconfdir}/sudoers.d/nova-rootwrap
    echo "root ALL=(root) NOPASSWD: ${bindir}/nova-rootwrap" > \
        ${D}${sysconfdir}/sudoers.d/nova-rootwrap

    # Configuration options
    sed -e "s:%SERVICE_TENANT_NAME%:${SERVICE_TENANT_NAME}:g" \
        ${TEMPLATE_CONF_DIR}/api-paste.ini > ${WORKDIR}/api-paste.ini
    sed -e "s:%SERVICE_USER%:${SRCNAME}:g" -i ${WORKDIR}/api-paste.ini
    sed -e "s:%SERVICE_PASSWORD%:${SERVICE_PASSWORD}:g" \
        -i ${WORKDIR}/api-paste.ini
    sed -e "s:%CONTROLLER_IP%:${CONTROLLER_IP}:g" -i ${WORKDIR}/api-paste.ini

    sed -e "s:%DB_USER%:${DB_USER}:g" -i ${WORKDIR}/nova.conf
    sed -e "s:%DB_PASSWORD%:${DB_PASSWORD}:g" -i ${WORKDIR}/nova.conf

    sed -e "s:%CONTROLLER_IP%:${CONTROLLER_IP}:g" -i ${WORKDIR}/nova.conf
    sed -e "s:%CONTROLLER_HOST%:${CONTROLLER_HOST}:g" -i ${WORKDIR}/nova.conf

    sed -e "s:%COMPUTE_IP%:${COMPUTE_IP}:g" -i ${WORKDIR}/nova.conf
    sed -e "s:%COMPUTE_HOST%:${COMPUTE_HOST}:g" -i ${WORKDIR}/nova.conf

    sed -e "s:%OS_PASSWORD%:${ADMIN_PASSWORD}:g" -i ${WORKDIR}/openrc
    sed -e "s:%SERVICE_TOKEN%:${SERVICE_TOKEN}:g" -i ${WORKDIR}/openrc

    sed -e "s:%CONTROLLER_IP%:${CONTROLLER_IP}:g" -i ${WORKDIR}/openrc
    sed -e "s:%CONTROLLER_HOST%:${CONTROLLER_HOST}:g" -i ${WORKDIR}/openrc

    # Copy the configuration file
    install -m 664 ${WORKDIR}/nova.conf     ${NOVA_CONF_DIR}/nova.conf
    install -m 664 ${WORKDIR}/api-paste.ini ${NOVA_CONF_DIR}
    install -m 664 ${WORKDIR}/openrc        ${NOVA_CONF_DIR}

    install -d ${NOVA_CONF_DIR}/instances

    if ${@base_contains('DISTRO_FEATURES', 'sysvinit', 'true', 'false', d)}; then
        install -d ${D}${sysconfdir}/init.d
        install -m 0755 ${WORKDIR}/nova-all ${D}${sysconfdir}/init.d/nova-all
        install -m 0755 ${WORKDIR}/nova-consoleauth ${D}${sysconfdir}/init.d/nova-consoleauth
        install -m 0755 ${WORKDIR}/nova-novncproxy ${D}${sysconfdir}/init.d/nova-novncproxy
    fi
}

pkg_postinst_${SRCNAME}-controller () {
    if [ "x$D" != "x" ]; then
        exit 1
    fi

    # This is to make sure postgres is configured and running
    if ! pidof postmaster > /dev/null; then
       /etc/init.d/postgresql-init
       /etc/init.d/postgresql start
       sleep 5
    fi

    sudo -u postgres createdb nova
    sleep 2
    nova-manage db sync
}

pkg_postinst_${SRCNAME}-common () {
    if [ "x$D" != "x" ]; then
        exit 1
    fi

    if [ -d  /home/root ]; then
        echo "source /etc/nova/openrc" > /home/root/.bashrc
    else
        echo "source /etc/nova/openrc" > /root/.bashrc
    fi
}

USERADD_PACKAGES = "${PN}"
GROUPADD_PARAM_${PN} = "--system nova"
USERADD_PARAM_${PN}  = "--system --home /var/lib/nova -g nova \
                        --no-create-home --shell /bin/false nova"

PACKAGES += " ${SRCNAME}-common ${SRCNAME}-compute ${SRCNAME}-controller"
PACKAGES += " ${SRCNAME}-consoleauth"
PACKAGES += " ${SRCNAME}-novncproxy"


FILES_${PN} = "${libdir}/*"

FILES_${SRCNAME}-common = "${bindir}/nova-manage \
                           ${bindir}/nova-rootwrap \
                           ${sysconfdir}/${SRCNAME}/* \
                           ${sysconfdir}/sudoers.d"

FILES_${SRCNAME}-compute = "${bindir}/nova-compute \
                            ${sysconfdir}/init.d/nova-compute"

FILES_${SRCNAME}-controller = "${bindir}/* \
 			       ${sysconfdir}/init.d/nova-all "

FILES_${SRCNAME}-consoleauth = " \
	${sysconfdir}/init.d/nova-consoleauth \
"
FILES_${SRCNAME}-novncproxy = " \
	${sysconfdir}/init.d/nova-novncproxy \
"

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

RDEPENDS_${SRCNAME}-common = "${PN} openssl openssl-misc libxml2 libxslt \
                              iptables curl dnsmasq sudo procps"

RDEPENDS_${SRCNAME}-controller = "${PN} ${SRCNAME}-common \
                                  ${SRCNAME}-consoleauth \
                                  ${SRCNAME}-novncproxy \
                                  postgresql postgresql-client python-psycopg2"

RDEPENDS_${SRCNAME}-compute = "${PN} ${SRCNAME}-common \
                               qemu libvirt libvirt-libvirtd libvirt-python libvirt-virsh"

INITSCRIPT_PACKAGES = "${SRCNAME}-controller ${SRCNAME}-consoleauth ${SRCNAME}-novncproxy"
INITSCRIPT_NAME_${SRCNAME}-controller = "nova-all"
INITSCRIPT_NAME_${SRCNAME}-consoleauth = "nova-consoleauth"
INITSCRIPT_NAME_${SRCNAME}-novncproxy = "nova-novncproxy"
