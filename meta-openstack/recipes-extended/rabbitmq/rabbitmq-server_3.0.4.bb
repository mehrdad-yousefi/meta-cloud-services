DESCRIPTION = "High-performance AMQP-compliant message broker written in Erlang."
HOMEPAGE = "http://www.rabbitmq.com/"
LICENSE = "MPL-1.1"
LIC_FILES_CHKSUM = "file://LICENSE-MPL-RabbitMQ;md5=10a81373a21abb63f98ef5dc93e1601a"
SECTION = "network"
DEPENDS = "erlang-native libxslt python-simplejson zip-native unzip-native libxslt-native"
PR = "r0"

SRC_URI = "http://www.rabbitmq.com/releases/rabbitmq-server/v${PV}/${PN}-${PV}.tar.gz \
           file://rabbitmq-server \
           file://remove-docs.patch \
           "

SRC_URI[md5sum] = "e4db90708fa2e9a687af342bbd2c0dd8"
SRC_URI[sha256sum] = "e49dbcfd8b2085133847de33081e2defb1f4879d21a9776d54ab1f1988e0e163"

RDEPENDS_${PN} = "erlang"

do_compile() {
    oe_runmake
}

do_install() {
    RABBIT_LIB_DIR=${D}${libdir}/rabbitmq/lib/${PN}-${PV}

    sed -e "s:^RABBITMQ_HOME=.*:RABBITMQ_HOME=\"${libdir}/rabbitmq/lib/${PN}-${PV}\":g" \
               -i ${S}/scripts/rabbitmq-env
    oe_runmake TARGET_DIR=${D} \
               SBIN_DIR=${D}/${bindir} \
               MAN_DIR=${D}/${mandir} install \

    install -d ${D}${libdir}/rabbitmq/lib/${PN}-${PV}

    install -d ${D}${localstatedir}/log/${PN}

    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/rabbitmq-server ${D}${sysconfdir}/init.d/rabbitmq-server

    mv ${D}/ebin ${RABBIT_LIB_DIR}/ebin
    mv ${D}/include ${RABBIT_LIB_DIR}/include
    mv ${D}/plugins ${RABBIT_LIB_DIR}/plugins
}

inherit useradd update-rc.d

USERADD_PACKAGES = "${PN}"
GROUPADD_PARAM_${PN} = "--system rabbitmq"
USERADD_PARAM_${PN}  = "--system --create-home --home /var/lib/rabbitmq \
			-g rabbitmq rabbitmq"

INITSCRIPT_NAME = "rabbitmq-server"
INITSCRIPT_PARAMS = "defaults"

FILES_${PN} += " ${libdir}/rabbitmq/lib/${PN}-${PV}/* \
                 ${localstatedir}/* \ 
               "

FILES_${PN}-doc += "LICENSE* INSTALL"
