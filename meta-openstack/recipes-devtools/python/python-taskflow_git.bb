DESCRIPTION = "A library to complete workflows/tasks in HA manner"
HOMEPAGE = "https://wiki.openstack.org/wiki/TaskFlow"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4476c4be31402271e101d9a4a3430d52"

SRC_URI = "\
	git://git.openstack.org/openstack/taskflow.git;branch=master \
	"

PV="1.21.0+git${SRCPV}"
SRCREV="52bd5e89fdddec49907a45e83a7a4b1abd1d1291"
S = "${WORKDIR}/git"

inherit setuptools

DEPENDS += " \
        python-pip \
        python-pbr \
        "

RDEPENDS_${PN} += " \
        python-pbr \
        python-anyjson \
        python-iso8601 \
        python-six \
        python-networkx \
        python-babel \
        python-stevedore \
        python-futures \
        python-futurist \
        python-fasteners \
        python-contextlib2 \
        python-monotonic \
        python-jsonschema \
        python-automaton \
        python-oslo.utils \
        python-oslo.serialization \
        python-cachetools \
        python-debtcollector \
        python-enum34 \
	"
