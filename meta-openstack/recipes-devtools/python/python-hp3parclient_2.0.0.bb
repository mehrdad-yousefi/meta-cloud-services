DESCRIPTION = "HP 3PAR HTTP REST Client"
HOMEPAGE = "https://pypi.python.org/pypi/hp3parclient/2.0.0"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=3b83ef96387f14655fc854ddc3c6bd57"

PR = "r0"
SRCNAME = "hp3parclient"

SRC_URI = "\
	https://pypi.python.org/packages/source/h/${SRCNAME}/${SRCNAME}-${PV}.tar.gz \
	file://fix_hp3parclient_memory_leak.patch \
	"

SRC_URI[md5sum] = "52cdcb930eb0dc81d93689abe169c502"
SRC_URI[sha256sum] = "bab78a3fa14236d7884af52271fd91d08d51ec99b7e2d6c6fb477bfdfb9ef259"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
