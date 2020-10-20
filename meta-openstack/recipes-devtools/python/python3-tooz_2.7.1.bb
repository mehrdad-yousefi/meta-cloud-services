DESCRIPTION = "Coordination library for distributed systems."
HOMEPAGE = "https://pypi.python.org/pypi/tooz"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

SRC_URI[md5sum] = "f8afa62d566f602d63050850d4873583"
SRC_URI[sha256sum] = "bee07684b12e9fb06adbe6b1a5ddb60ef9e8dc20f5a2d46e667d8797028bcfe5"

inherit setuptools3 pypi

# DEPENDS_default: python-pip

DEPENDS += " \
        python3-pip \
        python3-pbr \
        "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python3-pbr-native \
        "

# RDEPENDS_default:
RDEPENDS_${PN} += " \
        python3-pbr \
        python3-stevedore \
        python3-six \
        python3-voluptuous \
        python3-msgpack \
        python3-fasteners \
        python3-tenacity \
        python3-futurist \
        python3-oslo.utils \
        python3-oslo.serialization \
        "
