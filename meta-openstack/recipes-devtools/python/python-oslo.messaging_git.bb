DESCRIPTION = "Oslo Messaging API"
HOMEPAGE = "https://launchpad.net/oslo"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c46f31914956e4579f9b488e71415ac8"

SRCNAME = "oslo.messaging"
SRC_URI = "git://github.com/openstack/${SRCNAME}.git"

PV = "2.7.0+git${SRCPV}"
SRCREV = "4f49b7e25373d624ae9146dd46d92b90022c979f"
S = "${WORKDIR}/git"

inherit setuptools

# DEPENDS_default: python-pip

DEPENDS += " \
        python-pip \
        python-pbr \
        "

# RDEPENDS_default: 
RDEPENDS_${PN} += " \
        bash \
        python-pbr \
        python-cachetools \
        python-trollius \
        python-aioeventlet \
        python-futurist \
        python-oslo.config \
        python-oslo.context \
        python-oslo.log \
        python-oslo.utils \
        python-oslo.serialization \
        python-oslo.middleware \
        python-oslo.service \
        python-oslo.i18n \
        python-stevedore \
        python-six \
        python-eventlet \
        python-greenlet \
        python-webob \
        python-pyyaml \
        python-amqp \
        python-kombu \
        python-aioeventlet \
        "
