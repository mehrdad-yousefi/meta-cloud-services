#
# Copyright (C) 2014 Wind River Systems, Inc.
#
SUMMARY = "Ohai detects data about your operating system."
DESCRIPTION = "Ohai detects data about your operating system. It can \
be used standalone, but it's primary purpose is to provide node data \
to Chef. Ohai will print out a JSON data blob for all the known data \
about your system. When used with Chef, that data is reported back via \
node attributes."

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8f7bb094c7232b058c7e9f2e431f389c"

PR = "r0"

BPV = "7.0.4"
PV = "${BPV}"
SRCREV = "b306186701201bfc78b7bcc8908ee3524434cc93"

S = "${WORKDIR}/git"

SRC_URI = " \
    git://github.com/opscode/ohai.git \
    "

inherit ruby

RDEPENDS += " \
        mime-types \
        ipaddress \
        mixlib-cli \
        mixlib-config \
        mixlib-log \
        mixlib-shellout \
        systemu \
        yajl-ruby \
        "

BBCLASSEXTEND = "native"
