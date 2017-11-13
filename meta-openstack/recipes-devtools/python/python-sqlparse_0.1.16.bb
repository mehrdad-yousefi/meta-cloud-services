DESCRIPTION = "Non-validating SQL parser module"
HOMEPAGE = "http://pypi.python.org/pypi/sqlparse"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=13ec2f893997ca1f516b55496e019a81"

SRC_URI[md5sum] = "370962a307ebaaa70a28b6b0ccb53980"
SRC_URI[sha256sum] = "678c6c36ca4b01405177da8b84eecf92ec92c9f6c762396c965bb5d305f20f81"

export BUILD_SYS
export HOST_SYS

inherit setuptools pypi

# DEPENDS_default: python-pip

DEPENDS += " \
        "

# RDEPENDS_default: 
RDEPENDS_${PN} += " \
        "
