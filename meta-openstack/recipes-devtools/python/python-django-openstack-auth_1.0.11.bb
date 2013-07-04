DESCRIPTION = "A Django authentication backend for use with the OpenStack Keystone backend."
HOMEPAGE = "http://django_openstack_auth.readthedocs.org/"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=71fb36bc2e8b28fc3c770efe4d88b514"

PR = "r0"
SRCNAME = "django_openstack_auth"

SRC_URI = "https://pypi.python.org/packages/source/d/${SRCNAME}/${SRCNAME}-${PV}.tar.gz \
"

SRC_URI[md5sum] = "79e18b4bd3771adfc9cbd5ac0502a8b4"
SRC_URI[sha256sum] = "ac5a6f33457bc9e808c5bb9dbec0b2dbd36161c885559241e372bb34b2c9fa77"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools 

RDEPENDS_${PN} += "python-django  \
	python-keystoneclient  \
	"