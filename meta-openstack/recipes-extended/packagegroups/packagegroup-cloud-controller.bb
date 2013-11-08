SUMMARY = "Configuration for OpenStack Controller node"
PR = "r0"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit packagegroup

RDEPENDS_${PN} = " postgresql \
    postgresql-client \
    python-psycopg2 \
    rabbitmq-server \
    nova-controller \
    python-novaclient \
    glance \
    glance-api \
    glance-registry \
    keystone \
    neutron-server \
    neutron-plugin-openvswitch \
    openvswitch-controller \
    cinder-api \
    cinder-volume \
    cinder-scheduler \
    ceilometer-api \
    ceilometer-collector \
    ceilometer-controller \
    horizon \
    novnc \
    "
