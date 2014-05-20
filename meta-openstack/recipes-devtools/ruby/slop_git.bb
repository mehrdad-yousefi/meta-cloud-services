#
# Copyright (C) 2014 Wind River Systems, Inc.
#
SUMMARY = "A simple option parser with an simple syntax and API."
DESCRIPTION = "A simple option parser with an simple syntax and API."

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=66a8da2a5bee25570ffc35aa5426d176"

PR = "r0"

BPV = "3.5.0"
PV = "${BPV}"
SRCREV = "a009587ec2c0cf07b38bd8f0b59baa244fdbce51"

S = "${WORKDIR}/git"

SRC_URI = " \
    git://github.com/leejarvis/slop.git \
    "

inherit ruby

BBCLASSEXTEND = "native"
