DESCRIPTION = "croniter provides iteration for datetime object with cron like format"
HOMEPAGE = "https://pypi.python.org/pypi/croniter/0.3.4"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=e40c007e9fb06e926edd0ca838322b2b"

PR = "r0"

SRCNAME = "croniter"
SRC_URI = "http://pypi.python.org/packages/source/c/${SRCNAME}/${SRCNAME}-${PV}.zip"

SRC_URI[md5sum] = "0e82c181071558136d63ff3203f91290"
SRC_URI[sha256sum] = "a4cb85b6c8aafe56ff1cd22479bc3c22a70d2df758f314818ffb5b1f4d3e8189"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

DEPENDS += " \
        python-pip \
        "

RDEPENDS_${PN} += " \
        python-dateutil \
        "
