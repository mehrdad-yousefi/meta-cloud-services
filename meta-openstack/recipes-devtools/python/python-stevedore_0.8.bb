DESCRIPTION = "Manage dynamic plugins for Python applications"
HOMEPAGE = "https://github.com/dreamhost/stevedore"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

PR = "r0"

SRCNAME = "stevedore"
SRC_URI = "http://pypi.python.org/packages/source/s/stevedore/stevedore-0.8.tar.gz \
           file://remove-distribute-dependency.patch"

SRC_URI[md5sum] = "8f340230754c2d70e6e34bc6d8678048"
SRC_URI[sha256sum] = "bf187929f739f86a73ad218193d23bddb34c717c5adb6fd84008c2975043edb6"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
