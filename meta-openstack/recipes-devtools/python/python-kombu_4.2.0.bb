DESCRIPTION = "A messaging framework for Python"
HOMEPAGE = "http://kombu.readthedocs.org"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=daea7c168428449fbee05e644df929f4"

SRC_URI[md5sum] = "cb7e668936cd5ffc3232b72a2a4f931f"
SRC_URI[sha256sum] = "d601c47312833c0f6f4aaf037f293b2627398d4cf8526e6ba0360287294ee1fb"

inherit setuptools pypi

FILES_${PN}-doc += "${datadir}/${SRCNAME}"

RDEPENDS_${PN} = " \
        python-amqp \
        "
