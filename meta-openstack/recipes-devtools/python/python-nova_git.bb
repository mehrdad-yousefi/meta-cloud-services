DESCRIPTION = "Nova is a cloud computing fabric controller"
HOMEPAGE = "https://launchpad.net/nova"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

DEPENDS = "sudo libvirt"

PR = "r0"
SRCNAME = "nova"

FILESEXTRAPATHS := "${THISDIR}/${PN}"

SRC_URI = "git://github.com/openstack/${SRCNAME}.git;branch=stable/havana \
           file://0001-nova-api-paste.ini-make-controller-IP-configurable.patch \
           file://nova-add-migrate.cfg-to-the-MANIFEST.patch \
           file://Make-rbd.libvirt_info-parent-class-compatible.patch \
           file://Fix-rbd-backend-not-working-for-none-admin-ceph-user.patch \
           "

SRC_URI += "file://nova-all \
            file://nova.init \
            file://nova-consoleauth \
            file://nova-novncproxy \
            file://nova-spicehtml5proxy \
            file://nova.conf \
            file://openrc \
            file://nova-consoleproxy \
           "
SRCREV="afc9e4e23327fb566e8ade2c0c06c90d369c9e29"
PV="2013.2.2+git${SRCPV}"

S = "${WORKDIR}/git"

inherit update-rc.d setuptools identity hosts useradd default_configs

LIBVIRT_IMAGES_TYPE ?= "default"

do_install_append() {
    if [ ! -f "${WORKDIR}/nova.conf" ]; then
        return
    fi

    TEMPLATE_CONF_DIR=${S}${sysconfdir}/${SRCNAME}
    NOVA_CONF_DIR=${D}/${sysconfdir}/nova

    install -d ${NOVA_CONF_DIR}
    install -o nova -m 664 ${S}/etc/nova/policy.json ${NOVA_CONF_DIR}/

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
    # root user setup
    echo "root ALL=(root) NOPASSWD: ${bindir}/nova-rootwrap" > \
        ${D}${sysconfdir}/sudoers.d/nova-rootwrap
    # nova user setup
    echo "nova ALL=(root) NOPASSWD: ${bindir}/nova-rootwrap ${sysconfdir}/nova/rootwrap.conf *" >> \
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

    sed -e "s:%LIBVIRT_IMAGES_TYPE%:${LIBVIRT_IMAGES_TYPE}:g" -i ${WORKDIR}/nova.conf

    sed -e "s:%OS_PASSWORD%:${ADMIN_PASSWORD}:g" -i ${WORKDIR}/openrc
    sed -e "s:%SERVICE_TOKEN%:${SERVICE_TOKEN}:g" -i ${WORKDIR}/openrc

    sed -e "s:%CONTROLLER_IP%:${CONTROLLER_IP}:g" -i ${WORKDIR}/openrc
    sed -e "s:%CONTROLLER_HOST%:${CONTROLLER_HOST}:g" -i ${WORKDIR}/openrc

    # Copy the configuration file
    install -o nova -m 664 ${WORKDIR}/nova.conf     ${NOVA_CONF_DIR}/nova.conf
    install -o nova -m 664 ${WORKDIR}/api-paste.ini ${NOVA_CONF_DIR}
    install -o nova -m 664 ${WORKDIR}/openrc        ${NOVA_CONF_DIR}

    install -o nova -d ${NOVA_CONF_DIR}/instances

    if ${@base_contains('DISTRO_FEATURES', 'sysvinit', 'true', 'false', d)}; then
        install -d ${D}${sysconfdir}/init.d

	# nova-all is installed (and packaged), but not used as an initscript by default
        install -m 0755 ${WORKDIR}/nova-all ${D}${sysconfdir}/init.d/nova-all
        install -m 0755 ${WORKDIR}/nova-consoleauth ${D}${sysconfdir}/init.d/nova-consoleauth
        install -m 0755 ${WORKDIR}/nova-novncproxy ${D}${sysconfdir}/init.d/nova-novncproxy
        install -m 0755 ${WORKDIR}/nova-spicehtml5proxy ${D}${sysconfdir}/init.d/nova-spicehtml5proxy

	for binary in api compute network scheduler cert conductor; do
	    sed "s:@suffix@:$binary:" < ${WORKDIR}/nova.init >${WORKDIR}/nova-$binary.init.sh
            install -m 0755 ${WORKDIR}/nova-$binary.init.sh ${D}${sysconfdir}/init.d/nova-$binary
	done	
    fi

    cp run_tests.sh ${NOVA_CONF_DIR}

    install -D -o nova -m 664 ${WORKDIR}/nova-consoleproxy ${D}${sysconfdir}/default/nova-consoleproxy
}

pkg_postinst_${SRCNAME}-setup () {
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
USERADD_PARAM_${PN}  = "--system --home /var/lib/nova -g nova -G libvirt \
                        --no-create-home --shell /bin/false nova"

PACKAGES += " ${SRCNAME}-tests"
PACKAGES += " ${SRCNAME}-setup ${SRCNAME}-common ${SRCNAME}-compute ${SRCNAME}-controller"
PACKAGES += " ${SRCNAME}-consoleauth"
PACKAGES += " ${SRCNAME}-novncproxy"
PACKAGES += " ${SRCNAME}-spicehtml5proxy"
PACKAGES += " ${SRCNAME}-network"
PACKAGES += " ${SRCNAME}-scheduler"
PACKAGES += " ${SRCNAME}-cert"
PACKAGES += " ${SRCNAME}-conductor"
PACKAGES += " ${SRCNAME}-api"

ALLOW_EMPTY_${SRCNAME}-setup = "1"

FILES_${PN} = "${libdir}/*"

FILES_${SRCNAME}-tests = "${sysconfdir}/${SRCNAME}/run_tests.sh"

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
FILES_${SRCNAME}-spicehtml5proxy = " \
	${sysconfdir}/init.d/nova-spicehtml5proxy \
	${sysconfdir}/default/nova-consoleproxy \
"
FILES_${SRCNAME}-network = " \
	${sysconfdir}/init.d/nova-network \
"
FILES_${SRCNAME}-scheduler = " \
	${sysconfdir}/init.d/nova-scheduler \
"
FILES_${SRCNAME}-cert = " \
	${sysconfdir}/init.d/nova-cert \
"
FILES_${SRCNAME}-conductor = " \
	${sysconfdir}/init.d/nova-conductor \
"
FILES_${SRCNAME}-api = " \
	${sysconfdir}/init.d/nova-api \
"

DEPENDS += " \
        python-pip \
        python-pbr \
        "

RDEPENDS_${PN} = " libvirt \
		   python-modules \
		   python-misc \
		   python-argparse \
		   python-amqplib \
		   python-anyjson \
		   python-babel \
		   python-boto \
		   python-cinderclient \
		   python-cliff \
		   python-cheetah \
		   python-eventlet \
		   python-feedparser \
		   python-glanceclient \
		   python-greenlet \
		   python-httplib2 \
		   python-iso8601 \
		   python-jinja2 \
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
		   python-six \
		   python-setuptools \
		   python-sqlalchemy \
		   python-sqlalchemy-migrate \
		   python-stevedore \
		   python-suds \
		   python-neutronclient \
		   python-routes \
		   python-webob \
		   python-websockify \
		   python-pbr \
		   spice-html5 \
    "

RDEPENDS_${SRCNAME}-common = "${PN} openssl openssl-misc libxml2 libxslt \
                              iptables curl dnsmasq sudo procps"

RDEPENDS_${SRCNAME}-controller = "${PN} ${SRCNAME}-common \
				  ${SRCNAME}-consoleauth \
				  ${SRCNAME}-novncproxy \
				  ${SRCNAME}-spicehtml5proxy \
				  ${SRCNAME}-network \
				  ${SRCNAME}-scheduler \
				  ${SRCNAME}-cert \
				  ${SRCNAME}-conductor \
                                  ${SRCNAME}-api \
				  postgresql postgresql-client python-psycopg2"

RDEPENDS_${SRCNAME}-compute = "${PN} ${SRCNAME}-common \
			       qemu libvirt libvirt-libvirtd libvirt-python libvirt-virsh"
RDEPENDS_${SRCNAME}-setup = "postgresql sudo ${SRCNAME}-common"

INITSCRIPT_PACKAGES =  "${SRCNAME}-compute ${SRCNAME}-consoleauth ${SRCNAME}-novncproxy ${SRCNAME}-spicehtml5proxy"
INITSCRIPT_PACKAGES += "${SRCNAME}-network ${SRCNAME}-scheduler ${SRCNAME}-cert ${SRCNAME}-conductor"
INITSCRIPT_PACKAGES += "${SRCNAME}-api"

# nova-all can replace: network, scheduler, cert, conductor and api. 
# by default we go for the more granular initscripts, but this is left
# in case nova-all is desired.
# INITSCRIPT_PACKAGES += "${SRCNAME}-controller"
# INITSCRIPT_NAME_${SRCNAME}-controller = "nova-all"
INITSCRIPT_NAME_${SRCNAME}-network = "nova-network"
INITSCRIPT_PARAMS_${SRCNAME}-network = "${OS_DEFAULT_INITSCRIPT_PARAMS}"
INITSCRIPT_NAME_${SRCNAME}-scheduler = "nova-scheduler"
INITSCRIPT_PARAMS_${SRCNAME}-scheduler = "${OS_DEFAULT_INITSCRIPT_PARAMS}"
INITSCRIPT_NAME_${SRCNAME}-cert = "nova-cert"
INITSCRIPT_PARAMS_${SRCNAME}-cert = "${OS_DEFAULT_INITSCRIPT_PARAMS}"
INITSCRIPT_NAME_${SRCNAME}-conductor = "nova-conductor"
INITSCRIPT_PARAMS_${SRCNAME}-conductor = "${OS_DEFAULT_INITSCRIPT_PARAMS}"
INITSCRIPT_NAME_${SRCNAME}-api = "nova-api"
INITSCRIPT_PARAMS_${SRCNAME}-api = "${OS_DEFAULT_INITSCRIPT_PARAMS}"

INITSCRIPT_NAME_${SRCNAME}-compute = "nova-compute"
INITSCRIPT_PARAMS_${SRCNAME}-compute = "${OS_DEFAULT_INITSCRIPT_PARAMS}"
INITSCRIPT_NAME_${SRCNAME}-consoleauth = "nova-consoleauth"
INITSCRIPT_PARAMS_${SRCNAME}-consoleauth = "${OS_DEFAULT_INITSCRIPT_PARAMS}"
INITSCRIPT_NAME_${SRCNAME}-novncproxy = "nova-novncproxy"
INITSCRIPT_PARAMS_${SRCNAME}-novncproxy = "${OS_DEFAULT_INITSCRIPT_PARAMS}"

INITSCRIPT_NAME_${SRCNAME}-spicehtml5proxy = "nova-spicehtml5proxy"
INITSCRIPT_PARAMS_${SRCNAME}-spicehtml5proxy = "${OS_DEFAULT_INITSCRIPT_PARAMS}"
