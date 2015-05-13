DESCRIPTION = "Makes it easier to use PySCSS in Django."
HOMEPAGE = "https://github.com/fusionbox/django-pyscss"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=07339dad721a3ae7e420b8b751a15c70"


SRCNAME = "django-pyscss"
SRC_URI = "http://pypi.python.org/packages/source/d/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "4df1b89942f41b8e8bde8704efcfe6c2"
SRC_URI[sha256sum] = "03fa4d7e483d87eaa4df0e91b337d078a39fcca897952e8d65ebdca7f759a822"

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
        python-pathlib \
        "
