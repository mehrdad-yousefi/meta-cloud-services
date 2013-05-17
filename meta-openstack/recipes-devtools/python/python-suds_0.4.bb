DESCRIPTION = "Lightweight SOAP client"
HOMEPAGE = "https://fedorahosted.org/suds/"
SECTION = "devel/python"
LICENSE = "LGPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=847e96bce86d8774f491a92924343a29"

PR = "r0"
SRCNAME = "suds"

SRC_URI = "https://fedorahosted.org/releases/s/u/${SRCNAME}/${PN}-${PV}.tar.gz"

SRC_URI[md5sum] = "05523dfd3fc0de3f19dde4aca5dd17e9"
SRC_URI[sha256sum] = "66a2ee8dab56834d0a6b4ad88ed3daf2ff9824eeb9e5f66c93bf966d6db309d1"

inherit setuptools
