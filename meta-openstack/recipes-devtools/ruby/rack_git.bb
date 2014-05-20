#
# Copyright (C) 2014 Wind River Systems, Inc.
#
SUMMARY = "Provides an interface for developing web applications in Ruby."
DESCRIPTION = "Provides a minimal, modular and adaptable interface for \
developing web applications in Ruby. By wrapping HTTP requests and \
responses in the simplest way possible, it unifies and distills the \
API for web servers, web frameworks, and software in between (the \
so-called middleware) into a single method call."

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=53d9c9f5c6fd716007e621045f6caa49"

PR = "r0"

BPV = "1.5.2"
PV = "${BPV}"
SRCREV = "ac590d055c936bb9a618e955a690dc836c625211"

S = "${WORKDIR}/git"

SRC_URI = " \
    git://github.com/rack/rack.git \
    "

inherit ruby

BBCLASSEXTEND = "native"
