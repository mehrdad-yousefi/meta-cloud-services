DESCRIPTION = "oslo.db library"
HOMEPAGE = "http://launchpad.net/oslo"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

PV = "3.1.0+git${SRCPV}"
SRCREV = "3afd58f6ab0fc2acb1dd92f652cec48e87763cf6"

SRCNAME = "oslo.db"
SRC_URI = "git://github.com/openstack/${SRCNAME}.git"

S = "${WORKDIR}/git"

inherit setuptools

DEPENDS += " \
        python-pip \
        python-pbr \
        "

RDEPENDS_${PN} += " \
       python-six \
       python-alembic \
       python-babel \
       python-iso8601 \
       python-lockfile \
       python-oslo.config \
       python-oslo.i18n \
       python-oslo.context \
       python-oslo.utils \
       python-sqlalchemy \
       python-sqlalchemy-migrate \
       python-stevedore \
       python-pbr \
       "
