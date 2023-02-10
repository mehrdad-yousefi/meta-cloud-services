DESCRIPTION = "A library to complete workflows/tasks in HA manner"
HOMEPAGE = "https://wiki.openstack.org/wiki/TaskFlow"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4476c4be31402271e101d9a4a3430d52"

SRC_URI = "\
	git://git.openstack.org/openstack/taskflow.git;branch=master \
	"

PV="5.0.0+git${SRCPV}"
SRCREV="6dfc18013a2570c839828d6d879a9ab6a4964d91"
S = "${WORKDIR}/git"

inherit setuptools3

DEPENDS += " \
        python3-pip \
        python3-pbr \
        "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python3-pbr-native \
        "

RDEPENDS:${PN} += " \
        python3-pbr \
        python3-six \
        python3-futurist \
        python3-fasteners \
        python3-networkx \
        python3-contextlib2 \
        python3-stevedore \
        python3-jsonschema \
        python3-automaton \
        python3-oslo.utils \
        python3-oslo.serialization \
        python3-tenacity \
        python3-cachetools \
        python3-debtcollector \
        "
	
