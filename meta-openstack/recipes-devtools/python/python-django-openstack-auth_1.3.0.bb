DESCRIPTION = "A Django authentication backend for use with the OpenStack Keystone backend."
HOMEPAGE = "http://django_openstack_auth.readthedocs.org/"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

SRCNAME = "django_openstack_auth"

SRC_URI = "https://pypi.python.org/packages/source/d/${SRCNAME}/${SRCNAME}-${PV}.tar.gz \
"

SRC_URI[md5sum] = "a80e3b9660016336c5a2e4d4dd8a81a2"
SRC_URI[sha256sum] = "d7cb1e15c8582d6ac217619a891371e6dbb6bd4e15959214198490ea68e45e26"

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
