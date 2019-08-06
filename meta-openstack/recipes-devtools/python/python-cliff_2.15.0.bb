DESCRIPTION = "Command Line Interface Formulation Framework"
HOMEPAGE = "https://github.com/dreamhost/cliff"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI[md5sum] = "f51df6220d4a57c2b84d4b5a9e59e711"
SRC_URI[sha256sum] = "fe044273539250a99a5b9915843902e40e4e9b32ac5698c1fae89e31200d649f"

inherit setuptools pypi

DEPENDS += "\
    python-pbr \
    "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
    python-pbr-native \
    "

RDEPENDS_${PN} += "python-prettytable \
            python-cmd2 \
            python-pbr \
            python-pyparsing \
            python-prettytable \
            python-six \
            python-stevedore \
            python-unicodecsv \
            python-pyyaml \
"

CLEANBROKEN = "1"
