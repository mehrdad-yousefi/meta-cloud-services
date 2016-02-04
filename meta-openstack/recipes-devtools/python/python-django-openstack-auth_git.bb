DESCRIPTION = "A Django authentication backend for use with the OpenStack Keystone backend."
HOMEPAGE = "http://django_openstack_auth.readthedocs.org/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

SRCNAME = "django_openstack_auth"

PV = "2.0.0+git${SRCPV}"
SRCREV = "6e2cd8deffbd60074bf036c1cecdb280f281ccd4"

SRC_URI = "git://github.com/openstack/${SRCNAME}.git;branch=master \
"

S = "${WORKDIR}/git"

inherit setuptools 

DEPENDS += " \
        python-pip \
        python-pbr \
        "

RDEPENDS_${PN} += "python-django  \
	python-keystoneclient  \
	python-pbr \
	"
