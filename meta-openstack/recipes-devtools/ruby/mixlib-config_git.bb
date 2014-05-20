#
# Copyright (C) 2014 Wind River Systems, Inc.
#
SUMMARY = "Provides a class-based configuration object"
DESCRIPTION = "Provides a class-based configuration object, as used in \
Chef."

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8f7bb094c7232b058c7e9f2e431f389c"

PR = "r0"

BPV = "2.1.0"
PV = "${BPV}"
SRCREV = "c5e2dee2beb5fdd17442ff92e520f2ef01d17ee5"

S = "${WORKDIR}/git"

SRC_URI = " \
    git://github.com/opscode/mixlib-config.git \
    "

inherit ruby

BBCLASSEXTEND = "native"
