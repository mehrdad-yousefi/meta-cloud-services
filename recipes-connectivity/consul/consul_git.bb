DESCRIPTION = "A tool for discovering and configuring services in your infrastructure"
HOMEPAGE = "https://www.consul.io/"
LICENSE = "MPL-2.0 & BSD & Apache-2.0 & BSD-2-Clause & MIT"
LIC_FILES_CHKSUM = "file://src/github.com/hashicorp/consul/LICENSE;md5=b278a92d2c1509760384428817710378"

GO_IMPORT = "github.com/hashicorp/consul"
SRCREV = "f97afda8e15046b41d951bf3b4220372c45df7ab"
SRC_URI = "git://${GO_IMPORT}.git \
           file://consul.service \
           file://0001-prepared_query-make-compatible-with-go1.5.patch \
          "

S = "${WORKDIR}/git"

inherit systemd go

SYSTEMD_SERVICE_${PN} = "consul.service"
SYSTEMD_AUTO_ENABLE_${PN} = "enable"

do_install_append() {
    install -d ${D}/${systemd_unitdir}/system
    cp ${WORKDIR}/consul.service ${D}/${systemd_unitdir}/system
}

FILES_${PN} += "${systemd_unitdir}/system"

#for i586, executable consul contains textrel
INSANE_SKIP_${PN} += "textrel"
