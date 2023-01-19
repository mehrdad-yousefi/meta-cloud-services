DESCRIPTION = "Client library for OpenStack Object Storage API"
HOMEPAGE = "https://github.com/openstack/python-swiftclient"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

PYPI_PACKAGE = "python-swiftclient"

SRC_URI += " \
           file://avoids-duplicate-naming.patch \
          "

SRC_URI[sha256sum] = "f82298e4a48f7cbdd680f2638c85d1ca7ae1a76edbe30036d21b4cd7a29c09eb"

inherit pypi setuptools3 python3-dir

do_install:append() {
    cp -r test ${D}/${PYTHON_SITEPACKAGES_DIR}/${SRCNAME}/
}

DEPENDS += " \
        python3-pip \
        python3-pbr \
        "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python3-pbr-native \
        "

RDEPENDS:${PN} += " \
        python3-simplejson \
        python3-pbr \
        python3-requests \
        "
