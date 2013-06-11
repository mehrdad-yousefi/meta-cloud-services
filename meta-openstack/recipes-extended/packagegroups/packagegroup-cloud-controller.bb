SUMMARY = "Configuration for OpenStack Controller node"
PR = "r0"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS_${PN} = " postgresql \
    postgresql-client \
    python-psycopg2 \
    rabbitmq-server \
    nova-controller \
    python-novaclient \
    python-novaclient \
    glance \
    glance-api \
    glance-registry \
    keystone \
    quantum-server \
    quantum-plugin-openvswitch \
    openvswitch-controller \
    cinder-api \
    cinder-volume \
    "
