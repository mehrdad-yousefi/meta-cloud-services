DESCRIPTION = "A helper class for handling configuration defaults of packaged apps gracefully."
HOMEPAGE = "http://django-appconf.readthedocs.org/"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3f34b9b2f6413fd5f91869fa7e992457"

PR = "r0"
SRCNAME = "django-appconf"

SRC_URI = "https://pypi.python.org/packages/source/d/${SRCNAME}/${SRCNAME}-${PV}.tar.gz \
"

SRC_URI[md5sum] = "6971f6c9df6b5213797578fecc1845d7"
SRC_URI[sha256sum] = "06b64baf26c7a436cbb81464e7a50047aea30db1059dbe6e09dc443efa23ba20"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools 

#RDEPENDS_${PN} += "python-six \
#	"
