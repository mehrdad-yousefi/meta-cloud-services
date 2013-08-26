DESCRIPTION = "Nova is a cloud computing fabric controller"
HOMEPAGE = "https://launchpad.net/nova"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

DEPENDS = "sudo"

SRCNAME = "nova"
PYTHON_PN = "python-nova"

FILESEXTRAPATHS := "${THISDIR}/${PYTHON_PN}"

SRC_URI = "https://launchpad.net/${SRCNAME}/grizzly/${PV}/+download/${SRCNAME}-${PV}.tar.gz \
           file://0001-nova-api-paste.ini-make-controller-IP-configurable.patch \
           "

SRC_URI[md5sum] = "6215982b9ed08b9042e088470d60a0a6"
SRC_URI[sha256sum] = "f7c25186920daccb16867c5fd272318beb8cc076e5a55f79b5906618ef2724f4"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools identity

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
    sed -e "s:^filters_path=.*$:filters_path=${NOVA_CONF_DIR}/rootwrap.d:" \
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

    sed -e "s:%OS_PASSWORD%:${ADMIN_PASSWORD}:g" -i ${WORKDIR}/openrc
    sed -e "s:%SERVICE_TOKEN%:${SERVICE_TOKEN}:g" -i ${WORKDIR}/openrc

    sed -e "s:%CONTROLLER_IP%:${CONTROLLER_IP}:g" -i ${WORKDIR}/openrc
    sed -e "s:%CONTROLLER_HOST%:${CONTROLLER_HOST}:g" -i ${WORKDIR}/openrc

    # Copy the configuration file
    install -m 664 ${WORKDIR}/nova.conf     ${NOVA_CONF_DIR}/nova.conf
    install -m 664 ${WORKDIR}/api-paste.ini ${NOVA_CONF_DIR}
    install -m 664 ${WORKDIR}/openrc        ${NOVA_CONF_DIR}

    install -d ${NOVA_CONF_DIR}/instances
}

# note the lowercase "files", these variables are used in the packaging
# recipes themselves.
files_${PYTHON_PN} = "${libdir}/*"

files_${SRCNAME}-common = " ${bindir}/nova-manage \
                            ${bindir}/nova-rootwrap \
                            ${sysconfdir}/sudoers.d"

files_${SRCNAME}-compute = " ${bindir}/nova-compute \
                             ${sysconfdir}/${SRCNAME}/* \
                             ${sysconfdir}/init.d/nova-compute"

files_${SRCNAME}-controller = " ${bindir}/* \
                                ${sysconfdir}/${SRCNAME}/* \
                                ${sysconfdir}/init.d/nova-all"