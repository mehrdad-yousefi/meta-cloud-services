DESCRIPTION = "System V IPC primitives (semaphores, shared memory and message queues) for Python"
HOMEPAGE = "http://semanchuk.com/philip/sysv_ipc/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=4f09db8030b38bf57a442088a5a521ff"

PYPI_PACKAGE = "sysv_ipc"

SRC_URI[md5sum] = "9ef5167ed58a5a09e637cdfaeb8099d7"
SRC_URI[sha256sum] = "8eff10dd17789ddf21b422ce46ae0f6420088902a88e4296cb805cf2fde8b4dc"

inherit setuptools3 pypi

DEPENDS += " \
        ${PYTHON_PN}-pip \
        "

# RDEPENDS_default: 
RDEPENDS_${PN} += " \
        "
