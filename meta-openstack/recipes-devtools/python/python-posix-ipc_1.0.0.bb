DESCRIPTION = "POSIX IPC primitives (semaphores, shared memory and message queues) for Python"
HOMEPAGE = "http://semanchuk.com/philip/posix_ipc/"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d92bb5439aee694c0a87bfb51579e37b"

PYPI_PACKAGE = "posix_ipc"

# Archived version so we need to overwrite what the pypi class will derive
PYPI_SRC_URI = "https://pypi.python.org/packages/source/p/${PYPI_PACKAGE}/${PYPI_PACKAGE}-${PV}.tar.gz"

SRC_URI[md5sum] = "85607a392087715ac3a3c7ded2492d06"
SRC_URI[sha256sum] = "9c93070374ca672725575e5c9874930c8cde69367fb90378b2255e048e31efcb"

inherit setuptools pypi

# DEPENDS_default: python-pip

DEPENDS += " \
        python-pip \
        "

# RDEPENDS_default: 
RDEPENDS_${PN} += " \
        "
