DESCRIPTION = "Retry code until it succeeeds"
HOMEPAGE = "https://github.com/jd/tenacity"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=175792518e4ac015ab6696d16c4f607e"

inherit pypi

SRC_URI[md5sum] = "41e4e17cdedfa95fa626e528f596e151"
SRC_URI[sha256sum] = "29ae90e7faf488a8628432154bb34ace1cca58244c6ea399fd33f066ac71339a"

inherit setuptools3

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python3-pbr-native \
 	 python3-setuptools-scm-native \
        "

RDEPENDS_${PN} += " \
        python3-six \
        python3-monotonic \
        "
