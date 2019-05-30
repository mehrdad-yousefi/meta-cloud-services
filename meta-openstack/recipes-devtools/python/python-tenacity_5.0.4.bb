DESCRIPTION = "Retry code until it succeeeds"
HOMEPAGE = "https://github.com/jd/tenacity"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=175792518e4ac015ab6696d16c4f607e"

inherit pypi

SRC_URI[md5sum] = "2c8333b9f06d5889ea70955a004ae525"
SRC_URI[sha256sum] = "a0c3c5f7ae0c33f5556c775ca059c12d6fd8ab7121613a713e8b7d649908571b"

inherit setuptools

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python-pbr-native \
        "

RDEPENDS_${PN} += " \
        python-six \
        python-futures \
        python-monotonic \
        "
