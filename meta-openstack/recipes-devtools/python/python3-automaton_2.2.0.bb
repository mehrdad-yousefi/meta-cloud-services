DESCRIPTION = "Friendly state machines for python"
HOMEPAGE = "https://pypi.python.org/pypi/automaton"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d2794c0df5b907fdace235a619d80314"

SRC_URI[md5sum] = "00a1c07d012dfa228ce003d7527e4a7d"
SRC_URI[sha256sum] = "88144e0ec07c40edcb70a547ea74ca5718994e7a0694b6c4cb6679e57eb26095"

inherit setuptools3 pypi

DEPENDS += " \
        python3-pip \
        "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python3-pbr-native \
        "

RDEPENDS:${PN} += " \
        python3-pbr \
        python3-six \
        python3-debtcollector \
        python3-prettytable \
        "

