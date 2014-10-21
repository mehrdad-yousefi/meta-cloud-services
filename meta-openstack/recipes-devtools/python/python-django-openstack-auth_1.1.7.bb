DESCRIPTION = "A Django authentication backend for use with the OpenStack Keystone backend."
HOMEPAGE = "http://django_openstack_auth.readthedocs.org/"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

PR = "r0"
SRCNAME = "django_openstack_auth"

SRC_URI = "https://pypi.python.org/packages/source/d/${SRCNAME}/${SRCNAME}-${PV}.tar.gz \
"

SRC_URI[md5sum] = "6afb0748dab95003b75f0d6f4f4a1100"
SRC_URI[sha256sum] = "0884be8a97ff191799ed3f3d64b76c2f61299747af4a86d8a903766b2c175c6f"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools 

DEPENDS += " \
        python-pip \
        python-pbr \
        "

RDEPENDS_${PN} += "python-django  \
	python-keystoneclient  \
	python-pbr \
	"