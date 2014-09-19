#
# Copyright (C) 2014 Wind River Systems, Inc.
#
SUMMARY = "Provides a library and registry for info about MIME content type definitions."
DESCRIPTION = "The mime-types library provides a library and registry \
for information about MIME content type definitions. It can be used to \
determine defined filename extensions for MIME types, or to use \
filename extensions to look up the likely MIME type definitions."

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://Licence.rdoc;md5=4e3affb3326cd205b1b30bc0e1e8fd66"

PR = "r0"

BPV = "1.25.1"
PV = "${BPV}"
SRCREV = "6be836f59a041893cfc1c25668b3aa3552a7e334"

S = "${WORKDIR}/git"

SRC_URI = " \
    git://github.com/halostatue/mime-types.git;branch=v1-bug-fixes \
    "

inherit ruby

BBCLASSEXTEND = "native"
