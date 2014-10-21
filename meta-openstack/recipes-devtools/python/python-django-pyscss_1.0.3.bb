DESCRIPTION = "Makes it easier to use PySCSS in Django."
HOMEPAGE = "https://github.com/fusionbox/django-pyscss"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=07339dad721a3ae7e420b8b751a15c70"

PR = "r0"

SRCNAME = "django-pyscss"
SRC_URI = "http://pypi.python.org/packages/source/d/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "edc449f7fbe375cdf7f6079d67fe41da"
SRC_URI[sha256sum] = "255a097fa9c14a4a8b6b1bd1e2d775babb5814fd664d6e9dad399fca14ab9018"

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
