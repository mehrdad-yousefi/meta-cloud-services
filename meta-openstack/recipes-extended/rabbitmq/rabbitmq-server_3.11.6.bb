DESCRIPTION = "High-performance AMQP-compliant message broker written in Erlang."
HOMEPAGE = "http://www.rabbitmq.com/"
LICENSE = "MPL-1.1"
LIC_FILES_CHKSUM = "file://LICENSE-MPL-RabbitMQ;md5=815ca599c9df247a0c7f619bab123dad"
SECTION = "network"
PR = "r2"

SRC_URI = "https://github.com/rabbitmq/rabbitmq-server/releases/download/v${PV}/${PN}-${PV}.tar.xz \
           file://rabbitmq-server \
           file://rabbitmq-server.service \
           file://rabbitmq-server-setup \
           "

SRC_URI[md5sum] = "5450e1b093bf02d29f7b006b2760d67c"
SRC_URI[sha256sum] = "8302ebe685ef89976037152911ecea353fb49fa065b7a4651cc7b8f8e6631437"

DEPENDS = " \
    erlang-native \
    libxslt \
    python3-simplejson \
    zip-native \
    unzip-native \
    libxslt-native \
    coreutils-native\
"

RDEPENDS:${PN} = "erlang erlang-modules"

do_compile() {
    oe_runmake
}

do_install() {
    RABBIT_LIB_DIR=${D}${libdir}/rabbitmq/lib/${PN}-${PV}
    DOC_INSTALL_DIR="${D}${docdir}"

    sed -e "s:^RABBITMQ_HOME=.*:RABBITMQ_HOME=\"${libdir}/rabbitmq/lib/${PN}-${PV}\":g" \
               -i ${S}/scripts/rabbitmq-env
    oe_runmake TARGET_DIR=${D} \
               SBIN_DIR=${D}/${bindir} \
               MAN_DIR=${D}/${mandir} \
               DOC_INSTALL_DIR=${DOC_INSTALL_DIR} install \

    install -d ${D}${libdir}/rabbitmq/lib/${PN}-${PV}

    install -d ${D}${localstatedir}/log/${PN}

    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/rabbitmq-server ${D}${sysconfdir}/init.d/rabbitmq-server

    sed -e "s:%ROOT_HOME%:${ROOT_HOME}:" -i ${D}${sysconfdir}/init.d/rabbitmq-server

    mv ${D}/ebin ${RABBIT_LIB_DIR}/ebin
    mv ${D}/include ${RABBIT_LIB_DIR}/include
    mv ${D}/plugins ${RABBIT_LIB_DIR}/plugins

    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/rabbitmq-server.service ${D}${systemd_unitdir}/system

    if ${@bb.utils.contains('DISTRO_FEATURES','systemd','true','false',d)}; then
	install -d ${D}${bindir}
	install -m 0755 ${WORKDIR}/rabbitmq-server-setup ${D}${bindir}
    fi
}

inherit useradd update-rc.d systemd

USERADD_PACKAGES = "${PN}"
GROUPADD_PARAM:${PN} = "--system rabbitmq"
USERADD_PARAM:${PN}  = "--system --create-home --home /var/lib/rabbitmq \
			-g rabbitmq rabbitmq"

INITSCRIPT_NAME = "rabbitmq-server"
INITSCRIPT_PARAMS = "defaults"

SYSTEMD_SERVICE:${PN} = "rabbitmq-server.service"

FILES:${PN} += " ${libdir}/rabbitmq/lib/${PN}-${PV}/* \
                 ${localstatedir}/* \ 
               "

FILES:${PN}-doc += "LICENSE* INSTALL"
INSANE_SKIP:${PN} = "unsafe-references-in-scripts"
