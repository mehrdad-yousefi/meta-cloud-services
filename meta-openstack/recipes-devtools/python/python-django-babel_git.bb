DESCRIPTION = "Tools for using Babel with Django"
HOMEPAGE = "https://github.com/python-babel/django-babel"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=5ae97ab65116b8d7890c59de57577b46"

SRCNAME = "django-babel"

PV = "0.4.0+git${SRCPV}"
SRCREV = "37f2919bfc58215ab4f26d386a4e65670e3297b9"

SRC_URI = "git://github.com/python-babel/${SRCNAME}.git \
          "

S = "${WORKDIR}/git"

inherit setuptools

DEPENDS += " \
        python-pip \
        "

RDEPENDS_${PN} += " \
        python-django \
        python-nose \
        "

