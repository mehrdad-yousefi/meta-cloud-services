#
# Copyright (C) 2014 Wind River Systems, Inc.
#
SUMMARY = "Provides a robust system for requesting data from a user."
DESCRIPTION = "HighLine was designed to ease the tedious tasks of \
doing console input and output with low-level methods like gets() and \
puts(). HighLine provides a robust system for requesting data from a \
user, without needing to code all the error checking and validation \
rules and without needing to convert the typed Strings into what your \
program really needs. Just tell HighLine what you're after, and let it \
do all the work."

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=884766faee6a0d2931af978757e1a5fc"

PR = "r0"

BPV = "1.6.21"
PV = "${BPV}"
SRCREV = "4d5ec40d20853c73f1fd75c7681397bf50b05517"

S = "${WORKDIR}/git"

SRC_URI = " \
    git://github.com/JEG2/highline.git \
    "

inherit ruby

BBCLASSEXTEND = "native"
