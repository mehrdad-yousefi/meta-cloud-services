DESCRIPTION = "Build self-validating python objects using JSON schemas"
HOMEPAGE = "http://github.com/bcwaldon/warlock"
SECTION = "devel/python"
LICENSE = "Apache-2"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=3b83ef96387f14655fc854ddc3c6bd57"

DEPENDS += " \
        python-jsonschema \
        python-jsonpatch \
        "

SRC_URI[md5sum] = "8389225c589ada11a9094abc5d9053df"
SRC_URI[sha256sum] = "7c0d17891e14cf77e13a598edecc9f4682a5bc8a219dc84c139c5ba02789ef5a"

inherit setuptools pypi

RDEPENDS_${PN} += " \
        python-jsonschema \
        python-jsonpatch \
        python-six \
        "
