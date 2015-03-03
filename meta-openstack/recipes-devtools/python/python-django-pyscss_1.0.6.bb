DESCRIPTION = "Makes it easier to use PySCSS in Django."
HOMEPAGE = "https://github.com/fusionbox/django-pyscss"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=07339dad721a3ae7e420b8b751a15c70"

PR = "r0"

SRCNAME = "django-pyscss"
SRC_URI = "http://pypi.python.org/packages/source/d/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "dd96a50f663d4e079f4e6ac043ca5022"
SRC_URI[sha256sum] = "4575e65fa1a28529211ba22d7009e62d4f25a4ab2e7d7de14abea2e5b1c9f8f6"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

# DEPENDS_default: python-pip

DEPENDS += " \
        python-pip \
        "

# RDEPENDS_default: 
RDEPENDS_${PN} += " \
        python-django \
        python-pyscss \        
        "
