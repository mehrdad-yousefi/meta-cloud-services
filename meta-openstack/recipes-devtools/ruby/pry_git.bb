#
# Copyright (C) 2014 Wind River Systems, Inc.
#
SUMMARY = "Pry is an alternative to the standard IRB shell for Ruby."
DESCRIPTION = "Pry is a powerful alternative to the standard IRB shell \
for Ruby. It is written from scratch to provide a number of advanced \
features."

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7d1a6fbb73f604e1e716380490938bd4"

PR = "r0"

BPV = "0.9.12.6"
PV = "${BPV}"
SRCREV = "047788c4225b25bb0462e06715616964e4f0da15"

S = "${WORKDIR}/git"

SRC_URI = " \
    git://github.com/pry/pry.git \
    file://rdoc-fixup-opt.banner-heredoc.patch \
    "

inherit ruby

RUBY_COMPILE_FLAGS = ""

RDEPENDS_${PN} += " \
        coderay \
        method-source \
        slop \
        "

BBCLASSEXTEND = "native"
