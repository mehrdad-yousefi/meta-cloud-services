DESCRIPTION = "Python HTTP for Humans."
HOMEPAGE = "http://python-requests.org"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c858703330162aa799141655a10fe120"

PR = "r0"
SRCNAME = "requests"

SRC_URI = "http://pypi.python.org/packages/source/r/requests/requests-1.2.0.tar.gz"

SRC_URI[md5sum] = "22af2682233770e5468a986f451c51c0"
SRC_URI[sha256sum] = "cfa615644ae38efe8423ce9edb23470a4615a9147fa3cea5026afb47c9bb3913"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
