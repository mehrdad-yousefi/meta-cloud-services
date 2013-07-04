DESCRIPTION = "A helper class for handling configuration defaults of packaged apps gracefully."
HOMEPAGE = "http://django-appconf.readthedocs.org/"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3f34b9b2f6413fd5f91869fa7e992457"

PR = "r0"
SRCNAME = "django-appconf"

SRC_URI = "https://pypi.python.org/packages/source/d/${SRCNAME}/${SRCNAME}-${PV}.tar.gz \
"

SRC_URI[md5sum] = "40494042c3c8bd1e054c884e5ed4bb6c"
SRC_URI[sha256sum] = "a88ed8fb923a53c70c2c46fbe4508b5f81646b4b01401f1568a821671b33215c"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools 

#RDEPENDS_${PN} += "python-six \
#	"
