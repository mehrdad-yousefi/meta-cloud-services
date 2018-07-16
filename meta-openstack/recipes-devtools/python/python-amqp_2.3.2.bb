DESCRIPTION = "Low-level AMQP client for Python"
HOMEPAGE = "https://pypi.python.org/pypi/amqp/"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9d6ba772ac59c08a25a12ce15bd5f27b"

SRC_URI[md5sum] = "11fce0d01f4ee6886a02415c20cece80"
SRC_URI[sha256sum] = "073dd02fdd73041bffc913b767866015147b61f2a9bc104daef172fc1a0066eb"

inherit setuptools pypi

RDEPENDS_${PN} += " \
        python-vine \
        "
