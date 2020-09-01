DESCRIPTION = "Low-level AMQP client for Python"
HOMEPAGE = "https://pypi.python.org/pypi/amqp/"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9d6ba772ac59c08a25a12ce15bd5f27b"

SRC_URI[md5sum] = "c8cf9c75d7cd2e747fa49f3e3c47b3b1"
SRC_URI[sha256sum] = "70cdb10628468ff14e57ec2f751c7aa9e48e7e3651cfd62d431213c0c4e58f21"

inherit pypi setuptools3

RDEPENDS_${PN} += " \
        ${PYTHON_PN}-vine \
        "
