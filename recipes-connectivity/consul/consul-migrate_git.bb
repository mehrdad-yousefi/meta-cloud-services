SUMMARY = "Provides data migration for Consul server nodes"
HOMEPAGE = "https://github.com/hashicorp/consul-migrate"
LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b278a92d2c1509760384428817710378"

PKG_NAME = "github.com/hashicorp/consul-migrate"
SRC_URI = "git://${PKG_NAME}.git"
SRCREV = "678fb10cdeae25ab309e99e655148f0bf65f9710"

SRCREV_raft = "057b893fd996696719e98b6c44649ea14968c811"
SRCREV_go-metrics = "f303b03b91d770a11a39677f1d3b55da4002bbcb"
SRCREV_raft-boltdb = "d1e82c1ec3f15ee991f7cc7ffd5b67ff6f5bbaee"
SRCREV_raft-mdb = "4ec3694ffbc74d34f7532e70ef2e9c3546a0c0b0"
SRCREV_gomdb = "151f2e08ef45cb0e57d694b2562f351955dff572"
SRCREV_bolt = "c6ba97b89e0454fec9aa92e1d33a4e2c5fc1f631"
SRCREV_go-msgpack = "fa3f63826f7c23912c15263591e65d54d080b458"

SRC_URI += " \
   git://github.com/hashicorp/raft;name=raft;destsuffix=git/src/github.com/hashicorp/raft \
   git://github.com/armon/go-metrics;name=go-metrics;destsuffix=git/src/github.com/armon/go-metrics \
   git://github.com/hashicorp/raft-boltdb;name=raft-boltdb;destsuffix=git/src/github.com/hashicorp/raft-boltdb \
   git://github.com/hashicorp/raft-mdb;name=raft-mdb;destsuffix=git/src/github.com/hashicorp/raft-mdb \
   git://github.com/armon/gomdb;name=gomdb;destsuffix=git/src/github.com/armon/gomdb \
   git://github.com/boltdb/bolt;name=bolt;destsuffix=git/src/github.com/boltdb/bolt \
   git://github.com/hashicorp/go-msgpack;name=go-msgpack;destsuffix=git/src/github.com/hashicorp/go-msgpack \
"

inherit golang

SYSROOT_PREPROCESS_FUNCS += "consul_migrate_sysroot_preprocess"

export GOROOT="${STAGING_DIR_NATIVE}/${nonarch_libdir}/${HOST_SYS}/go"

consul_migrate_sysroot_preprocess () {
    install -d ${SYSROOT_DESTDIR}${prefix}/local/go/src/${PKG_NAME}
    cp -a ${D}${prefix}/local/go/src/${PKG_NAME} ${SYSROOT_DESTDIR}${prefix}/local/go/src/$(dirname ${PKG_NAME})
    install -d ${SYSROOT_DESTDIR}${prefix}/bin
    cp -a ${D}${prefix}/bin/* ${SYSROOT_DESTDIR}${prefix}/bin/
}

CLEANBROKEN = "1"
INSANE_SKIP_${PN} = "ldflags"
