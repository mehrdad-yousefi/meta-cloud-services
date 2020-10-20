DESCRIPTION = "Python promises"
HOMEPAGE = "https://pypi.python.org/pypi/vine"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6fadb0e48ceb84b571372dd706ed76a0"

SRC_URI[md5sum] = "2fc3270a999cdc9341ba173360d62367"
SRC_URI[sha256sum] = "7d3b1624a953da82ef63462013bbd271d3eb75751489f9807598e8f340bd637e"

inherit setuptools3 pypi

RDEPENDS_${PN} += " \
        "
