DESCRIPTION = "Nova is a cloud computing fabric controller"
HOMEPAGE = "https://launchpad.net/nova"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

DEPENDS = "sudo"

PR = "r0"
SRCNAME = "nova"

SRC_URI = "https://launchpad.net/${SRCNAME}/grizzly/${PV}/+download/${SRCNAME}-${PV}.tar.gz \
           file://nova.conf \
           file://api-paste.ini"


SRC_URI[md5sum] = "38022353c398ce38c4e220d1d18b5916"
SRC_URI[sha256sum] = "db7f5259d848358bf14105d5833869ec145f643312e6bc0adef0050120fe3e07"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools useradd

do_install_append() {

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
    sed -e "s:^filters_path=.*$:filters_path=${NOVA_CONF_DIR}/rootwrap.d:" -i ${NOVA_CONF_DIR}/rootwrap.conf
    chown root:root $NOVA_CONF_DIR/rootwrap.conf

    # Set up the rootwrap sudoers for nova
    install -d ${D}${sysconfdir}/sudoers.d
    touch ${D}${sysconfdir}/sudoers.d/nova-rootwrap
    chmod 0440 ${D}${sysconfdir}/sudoers.d/nova-rootwrap
    chown root:root ${D}${sysconfdir}/sudoers.d/nova-rootwrap
    echo "root ALL=(root) NOPASSWD: ${bindir}/nova-rootwrap" > ${D}${sysconfdir}/sudoers.d/nova-rootwrap

    #Copy the configuration file
    install -m 664 ${WORKDIR}/nova.conf     ${NOVA_CONF_DIR}/nova.conf
    install -m 664 ${WORKDIR}/api-paste.ini ${NOVA_CONF_DIR}

    # Create the sqlite database
    #touch ${NOVA_CONF_DIR}/nova.db
    install -d ${NOVA_CONF_DIR}/instances
}

inherit useradd

USERADD_PACKAGES = "${PN}"
GROUPADD_PARAM_${PN} = "--system nova"
USERADD_PARAM_${PN}  = "--system --home /var/lib/nova -g nova \
                        --no-create-home --shell /bin/false nova"

pkg_postinst_${PN} () {
    if [ "x$D" != "x" ]; then
        exit 1
    fi

    # Needed when using a MySQL backend
    # mysql -u root -e "CREATE DATABASE nova CHARACTER SET latin1;"
    sudo -u postgres createdb nova
    nova-manage db sync
}



FILES_${PN} += "${sysconfdir}/${SRCNAME}/* \
                ${sysconfdir}/sudoers.d "

RDEPENDS_${PN} = "openssl openssl-misc libxml2 libxslt iptables curl dnsmasq sudo procps\
    qemu libvirt libvirt-libvirtd libvirt-python libvirt-virsh \
    python-modules \
    python-misc \
    python-argparse \
    libvirt-python \
	libvirt-libvirtd \
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
