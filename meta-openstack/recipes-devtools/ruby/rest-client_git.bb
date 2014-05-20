#
# Copyright (C) 2014 Wind River Systems, Inc.
#
SUMMARY = "A simple HTTP and REST client for Ruby"
DESCRIPTION = "A simple HTTP and REST client for Ruby, inspired by the \
Sinatra's microframework style of specifying actions: get, put, post, \
delete."

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://README.rdoc;beginline=285;md5=f649e8be3b8f05776195b7aa04d974c6"

PR = "r0"

BPV = "1.6.7"
PV = "${BPV}"
SRCREV = "d96be9d1dc8b1b4c04d90a62244b87ded8d86f0c"

S = "${WORKDIR}/git"

SRC_URI = " \
    git://github.com/rest-client/rest-client.git \
    "

inherit ruby

RDEPENDS += " \
        mime-types \
        "

BBCLASSEXTEND = "native"
