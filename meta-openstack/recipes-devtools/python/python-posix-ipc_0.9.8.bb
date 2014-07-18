DESCRIPTION = "POSIX IPC primitives (semaphores, shared memory and message queues) for Python"
HOMEPAGE = "http://semanchuk.com/philip/posix_ipc/"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d92bb5439aee694c0a87bfb51579e37b"

PR = "r0"

SRCNAME = "posix_ipc"
SRC_URI = "http://pypi.python.org/packages/source/p/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "f3e78df4ab4e0f43ea04ef5c53563970"
SRC_URI[sha256sum] = "271446eb133efb7410eb51265807aa54e0acb8eb7c2abcf027e51b4cb36d36dd"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

# DEPENDS_default: python-pip

DEPENDS += " \
        python-pip \
        "

# RDEPENDS_default: 
RDEPENDS_${PN} += " \
        "
