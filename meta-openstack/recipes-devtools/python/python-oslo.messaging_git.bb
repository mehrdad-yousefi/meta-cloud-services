DESCRIPTION = "Oslo Messaging API"
HOMEPAGE = "https://launchpad.net/oslo"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c46f31914956e4579f9b488e71415ac8"

SRCNAME = "oslo.messaging"
SRC_URI = "git://github.com/openstack/${SRCNAME}.git;branch=stable/newton"

PV = "5.10.1+git${SRCPV}"
SRCREV = "cc1ec4e7f3b395d5f25e7d4922e6359b58a2206a"
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
        python-debtcollector \
        python-monotonic \
        python-six \
        python-eventlet \
        python-greenlet \
        python-webob \
        python-pyyaml \
        python-amqp \
        python-kombu \
        python-pika \
        python-pika-pool \
        python-futures \
        python-retrying \
        "
