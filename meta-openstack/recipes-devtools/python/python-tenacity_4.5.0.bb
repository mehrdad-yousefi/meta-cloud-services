DESCRIPTION = "Retry code until it succeeeds"
HOMEPAGE = "https://github.com/jd/tenacity"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=175792518e4ac015ab6696d16c4f607e"

inherit pypi

SRC_URI[md5sum] = "7bb60e2bfa59797d415724d7cb770973"
SRC_URI[sha256sum] = "e5eb0009d7fef345ffd27e43122ec288418b460952aeefde60df8e62c3953d4b"

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
