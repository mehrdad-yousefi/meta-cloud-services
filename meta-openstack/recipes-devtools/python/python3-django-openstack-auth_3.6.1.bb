DESCRIPTION = "A Django authentication backend for use with the OpenStack Keystone backend."
HOMEPAGE = "http://django_openstack_auth.readthedocs.org/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

PYPI_PACKAGE = "django_openstack_auth"

SRC_URI[sha256sum] = "9a441fdea3f662fd727f020f479b3e89c96a2cc442c49539634c996a967dd378"

inherit setuptools3 pypi

DEPENDS += " \
        python3-pip \
        python3-pbr-native \
        "

RDEPENDS_${PN} += " \
        python3-pbr \
        python3-django \
        python3-oslo.config \
        python3-oslo.policy \
        python3-keystoneclient \
        python3-keystoneauth1 \
        python3-six \
        "
