#
# Copyright (C) 2014 Wind River Systems, Inc.
#
SUMMARY = "A simple HTTP and REST client for Ruby"
DESCRIPTION = "A simple HTTP and REST client for Ruby, inspired by the \
Sinatra's microframework style of specifying actions: get, put, post, \
delete."

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8d4c0cdd6bc54a36dbe54c0f2fa70797"

PR = "r0"

BPV = "1.7.3"
PV = "${BPV}"
SRCREV = "988d5a81ff3081c1c6a3ab267e81a9fff94bd9e4"

S = "${WORKDIR}/git"

SRC_URI = " \
    git://github.com/rest-client/rest-client.git \
    "

inherit ruby

RDEPENDS_${PN} += " \
        mime-types \
        "

BBCLASSEXTEND = "native"
