DESCRIPTION = "Tools required to be installed on Heat provisioned cloud instances"
HOMEPAGE = "https://github.com/openstack/heat-cfntools"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

SRC_URI[md5sum] = "395e95fecdfa47a89e260998fd5e50b4"
SRC_URI[sha256sum] = "8608e11c2cfdd198bbead763a1a73008a17111c67e44a7e299922f4d5da8ca33"

inherit setuptools3 pypi

DEPENDS += "\
    python3-pbr \
    "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python3-pbr-native \
        "

RDEPENDS:${PN} += "\
    python3-pbr \
    "
